const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let age;

rl.on("line", (line) => {
  if (age === undefined) {
    age = parseInt(line);
  } else {
    const height = parseInt(line);
    const canEnter = age < 14 && height < 155;
    console.log(canEnter ? "O" : "X");
    rl.close();
  }
});