fun main() {
  val filepath = "/workspaces/comp2850-oop-work/portfolio/wordle/data/words.txt"
  val wordsList = readWordList(filepath)
  val answer = pickRandomWord(wordsList)
  
  var attempt = 1
  while (attempt <= 10) {
    var valid = false
    var guess = ""
    while (valid == false) {
        guess = obtainGuess(attempt)
        valid = isValid(guess, wordsList)
    }
    val matches = evaluateGuess(guess, answer)
    val output = displayGuess(guess, matches)
    if (0 in matches) {
        attempt+=1
    }
    else {
        print("Correct!")
        break
    }
  if (attempt > 10) {
    println("You have run out of guesses!")
    println("The word was ${answer}")
  }

  }
}
