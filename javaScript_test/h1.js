const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  const students = line.split(" ").map((t) => Number.parseInt(t));

  const promises = students.map((time, i) => {
    return new Promise((resolve) => {
      setTimeout(() => {
        console.log(String.fromCharCode("A".charCodeAt(0) + i) + " 마킹");
        resolve();
      }, time * 1000);
    });
  });

  Promise.all(promises).then(() => {
    console.log("시험이 종료되었습니다.");
  });

  rl.close();
});