import java.io.File

fun isValid(word: String, wordList: MutableList<String>): Boolean {
    if (word.length == 5 && word in wordList) {
        return true
    }
    else {
        return false
    }
}

fun readWordList(filename: String): MutableList<String> = File(filename).readLines().toMutableList()

fun pickRandomWord(words: MutableList<String>): String = words.random()

fun obtainGuess(attempt: Int): String {
    print("Attempt $attempt:")
    var guess = readln()
    return guess
}

fun evaluateGuess(guess: String, target: String): List<Int> {
    var correct = mutableListOf<Int>()
    for (n in 0..<target.length) {
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
    println(output)
}