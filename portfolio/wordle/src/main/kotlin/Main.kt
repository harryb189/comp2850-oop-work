fun main() {
  val filepath = "/COMP2850-OOP-WORK/portfolio/wordle/data/words.txt"
  val wordsList = readWordList(filepath)
  val answer = pickRandomWord(wordsList)
  
  var attempt = 1
  while (attempt <= 10) {
    val guess = obtainGuess(attempt)
    val matches = evaluateGuess(guess)
    val output = displayGuess(guess, matches)
    if (0 in matches) {
        attempt+=1
    }
    else {
        print("Correct!")
        break
    }

  }
}
