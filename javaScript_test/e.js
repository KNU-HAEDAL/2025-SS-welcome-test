const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

let year;

rl.on("line", (line) => {
  if (year === undefined) {
    year = parseInt(line);
  } else {
    const month = parseInt(line);
    let days;

    if ([4, 6, 9, 11].includes(month)) {
      days = 30;
    } else if (month === 2) {
      days = (year % 4 === 0 && year % 100 !== 0) || year % 400 === 0 ? 29 : 28;
    } else {
      days = 31;
    }

    console.log(days);
    rl.close();
  }
});