const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

rl.on("line", (line) => {
  const vowels = ["a", "e", "i", "o", "u"];
  const hasVowel = vowels.some((vowel) => line.includes(vowel));

  console.log(hasVowel ? "O" : "X");
  rl.close();
});