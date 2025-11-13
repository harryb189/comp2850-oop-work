import java.io.File

fun isValid(word: String): Boolean {
    if (word.length == 5) {
        return true
    }
    else {
        return false
    }
}

fun readWordList(filename: String): List<String> = File(filename).readLines()

fun pickRandomWord(words: MutableList<String>): String = words.random()

fun obtainGuess(attempt: Int): String {
    var valid = false
    var guess = ""
    while (valid == false) {
        print("Attempt $attempt:")
        guess = readln()
        valid = isValid(guess)
    }
    return guess
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    var correct = listOf<Int>()
    for (n in 0..target.length) {
        if (guess[n]==target[n]) {
            correct.add(1)
        }
        else {
            correct.add(0)
        }
    }
    return correct
}

fun displayGuess(guess: String, matches: List<Int>) {
    var output = ""
    for (n in guess.indices) {
        if (matches[n] == 1) {
            output += guess[n]
        }
        else {
            output += "?"
        }
    }
    print(output)
}