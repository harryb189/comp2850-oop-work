fun isValid(word: String): Boolean {
    if (word.length == 5) {
        return true
    }
    else {
        return false
    }
}

fun readWordList(filename: String): MutableList<String> = File(filename).readlines()

fun pickRandomWord(words: MutableList<String>): String = words.random()

fun obtainGuess(attempt: Int): String {
    var valid = false
    while (valid == false) {
        print("Attempt $attempt:")
        val guess = readln()
        valid = isValid(guess)
    }
    return guess
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    for (n in 0..target.length) {
        
    }
}

fun displayGuess(guess: String, matches: List<Int>) {

}