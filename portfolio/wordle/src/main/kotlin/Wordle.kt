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
    print("Attempt $attempt:")
    val guess = readln()
    return guess
}

fun evaluateGuess(guess: String, target: String): List<Int> {

}

fun displayGuess(guess: String, matches: List<Int>) {

}