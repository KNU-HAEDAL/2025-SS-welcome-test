const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  const N = parseInt(line);

  // 상단 삼각형
  for (let i = 1; i <= N; i++) {
    console.log(" ".repeat(N - i) + "*".repeat(2 * i - 1));
  }

  // 하단 삼각형 (맨 위 줄 제외)
  for (let i = N - 1; i >= 1; i--) {
    console.log(" ".repeat(N - i) + "*".repeat(2 * i - 1));
  }

  rl.close();
});