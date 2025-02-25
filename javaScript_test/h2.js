const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const check = (times) => {
  if (times.length != 3) return false;
  times.forEach((time) => {
    if (time <= 0) {
      console.log(time);
      return false;
    }
  });

  return true;
};

const now = () => {
  const date = new Date();

  return `${date.getFullYear()}. ${date.getMonth() + 1}. ${date.getDate()}. ${
    date.getHours() > 11 ? "오후" : "오전"
  } ${date.getHours()}:${date.getMinutes()}:${date.getSeconds()}`;
};

rl.on("line", (line) => {
  const times = line.split(" ").map((t) => Number.parseInt(t));

  if (times.length != 3) {
    console.log("잘못된 입력입니다. 0보다 큰 숫자 세 개를 입력하세요.");
    process.exit();
  }

  times.forEach((time) => {
    if (time <= 0) {
      console.log("잘못된 입력입니다. 0보다 큰 숫자 세 개를 입력하세요.");
      process.exit();
    }
  });

  const cnt = [0, 0, 0];
  const flag = [false, false, false];

  const a = setInterval(() => {
    if (++cnt[0] == times[0]) {
      clearInterval(a);
      flag[0] = true;
      console.log(`(${cnt[0]}초 후) A 작업 완료!`);
    } else console.log(`(${cnt[0]}초 후) A 작업 진행 중... (${cnt[0]}초 경과)`);
  }, 1000);

  const b = setInterval(() => {
    if (++cnt[1] == times[1]) {
      clearInterval(b);
      flag[1] = true;
      console.log(`(${cnt[1]}초 후) B 작업 완료!`);
    } else console.log(`(${cnt[1]}초 후) B 작업 진행 중... (${cnt[1]}초 경과)`);
  }, 1000);
  const c = setInterval(() => {
    if (++cnt[2] == times[2]) {
      clearInterval(c);
      flag[2] = true;
      console.log(`(${cnt[2]}초 후) C 작업 완료!`);
    } else console.log(`(${cnt[2]}초 후) C 작업 진행 중... (${cnt[2]}초 경과)`);
  }, 1000);

  const lastTime = Math.max(...times);
  const done = setInterval(() => {
    if (flag[0] && flag[1] && flag[2]) {
      clearTimeout(done);
      console.log(
        `(${lastTime}초 후) 프로젝트 배포 완료! (완료 시각: ${now()})`
      );
    }
  }, 1000);

  rl.close();
});