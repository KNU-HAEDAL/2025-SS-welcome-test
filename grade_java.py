# 해달 부트캠프 과제 채점 프로그램
# Java 코드를 컴파일하고 실행하여 테스트 케이스를 통과하는지 확인합니다.

import os
import sys
import time
import threading
import itertools
import subprocess

def spinner(stop):
    spinner = itertools.cycle(['-', '/', '|', '\\'])
    while not stop():
        sys.stdout.write(next(spinner) + ' 채점 중입니다.')
        sys.stdout.flush()
        sys.stdout.write('\r')
        time.sleep(0.1)

def print_welcome():
    print("🌟 해달 부트캠프 과제 채점기 🌟")

def print_result(problem: str, result: dict[int, tuple[bool, str]]):
    sys.stdout.write('\r                              \n')
    sys.stdout.flush()

    print(f"📝 {problem} 문제 채점 결과")

    for number, (success, message) in result.items():
        if  success:
            print(f"✅ 테스트 {number}: 통과")
        else:
            print(f"❌ 테스트 {number}: {message}")

def run(java_file: str, input_data) -> list[tuple[str, float]]:
    start_time = time.time()

    # Java 파일 컴파일
    compile_process = subprocess.run(["javac", java_file], capture_output=True, text=True)
    if compile_process.returncode != 0:
        return [("Compilation Error: " + compile_process.stderr, 0)]

    # 컴파일된 클래스 파일 실행
    class_file = os.path.splitext(java_file)[0]

    try:
        process = subprocess.Popen(
            ["java", class_file],
            stdin=subprocess.PIPE,
            stdout=subprocess.PIPE,
            stderr=subprocess.PIPE,
            text=True,
        )

        stdout_data, stderr_data = process.communicate(input=input_data, timeout=10,)

    except subprocess.TimeoutExpired:
        process.kill()
        return []
    
    if process.returncode != 0:
        return []

    output = []
    elapsed = time.time() - start_time
    for line in stdout_data.splitlines():
        output.append((line, elapsed))

    return output

# a, b, c, e, d, f 문제를 채점하는 함수
def compare(answer: list[str], output: list[tuple[str, float]]) -> tuple[bool, str]:
    # print(f"answer: {answer}\noutput: {output}")
    # print()
    timeout = 5

    if len(answer) != len(output):
        return (False, "정답이 아닙니다.")

    for _, (expected, (actual, elapsed)) in enumerate(zip(answer, output)):
        if expected != actual:
            return (False, "정답이 아닙니다.")
        if elapsed > timeout:
            return (False, "시간 초과")

    return (True, "테스트 통과")

def check(problem: str) -> dict[int, tuple[bool, str]]:
    stop_spinner = False
    spinner_thread = threading.Thread(target=spinner, args=(lambda: stop_spinner,))
    spinner_thread.start()

    check_table = {
        1: (False, ""),
        2: (False, ""),
        3: (False, ""),
        4: (False, ""),
        5: (False, ""),
    }

    for number in range(1, 6):
        input_txt = os.path.join(os.path.dirname(__file__), f"answer/{problem}/input{number}.txt")
        output_txt = os.path.join(os.path.dirname(__file__), f"answer/{problem}/output{number}.txt")
        java_file = os.path.join(os.path.dirname(__file__), f"java_test/{problem}.java")
        
        # 파일 끝까지 읽어서 한 문장으로 만들기
        try:
            f = open(input_txt)
            input_data = f.read()
        except FileNotFoundError:
            raise FileNotFoundError(f"입력 파일이 존재하지 않습니다.: {problem}/input{number}.txt")

        expected_output = []
        try:
            f = open(output_txt)
            for line in f:
                expected_output.append(line.rstrip())
        except FileNotFoundError:
            raise FileNotFoundError(f"출력 파일이 존재하지 않습니다.: {problem}/output{number}.txt")
        
        try:
            f = open(java_file)
        except FileNotFoundError:
            raise FileNotFoundError(f"Java 파일이 존재하지 않습니다.: {problem}.java")

        # 실행
        output = run(f"java_test/{problem}.java", input_data)

        check_table[number] = compare(expected_output, output)

    stop_spinner = True
    spinner_thread.join()
    sys.stdout.write('\r')
    sys.stdout.flush()
    
    return check_table

def main():
    print_welcome()

    perfect = True
    for problem in ('a', 'b', 'c', 'd', 'e', 'f', 'g1', 'g2'):
        check_table = check(problem)
        for success, _ in check_table.values():
            perfect = success and perfect
        print_result(problem, check_table)
    

    print()
    if perfect:
        print("🎉 모든 문제를 성공적으로 통과하였습니다.")
    else:
        print("😢 아쉽게도 모든 문제를 통과하지 못하였습니다.")
        exit(1)


if __name__ == '__main__':
    main()