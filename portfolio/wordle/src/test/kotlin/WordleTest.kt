import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({

    val testWords = listOf("IRATE, CLOUD, APPLE, TREES, CLEAN, MONEY, RUGBY, SOLID")

    "Words of 5 letters that are in the word list should be valid - isValid" {
        withClue("Word=IRATE") { isValid("IRATE", testWords) shouldBe true}
        withClue("Word=CLOUD") { isValid("Cloud", testWords) shouldBe true}
        withClue("Word=APPLE") { isValid("apple", testWords) shouldBe true}
    }

    "Words of not length 5 should be invalid - isValid" {
        withClue("Word=SURGERY") { isValid("Surgery", testWords) shouldBe false}
        withClue("Word=COMPANY") { isValid("Company", testWords) shouldBe false}
    }

    "Words of 5 letters not in the word list should be invalid - isValid" {
        withClue("Word=SILIE") { isValid("SILIE", testWords) shouldBe false}
        withClue("Word=TREE8") { isValid("Treee", testWords) shouldBe false}
    }

    "All words read from the file into a list - readWordList" {
        val file = tempFile()
        val testWords = listOf("football", "rugby", "boxing")
        file.writeLines(testWords)
        {readWordList(file) shouldBe testWords}

    }

    "pickRandomWord should return random word from entered list" {
        val words = listOf("rugby", "football", "boxing", "golf", "hockey", "mma", "sprinting", "american football")
        {words shouldContain pickRandomWord(words)}
    }

    "evaluateGuess - Correct answer should return all 1s" {
        {evaluateGuess("CLOUD", "CLOUD") shouldBe listOf(1, 1, 1, 1, 1)}
        {evaluateGuess("IRATE", "IRATE") shouldBe listOf(1, 1, 1, 1, 1)}
    }

    "Checking evaluateGuess returns correct 0 and 1s order" {
        {evaluateGuess("APPLE", "ACTOR") shouldBe listOf(1, 0, 0, 0, 0)}
        {evaluateGuess("ABBOT", "ABBEY") shouldBe listOf(1, 1, 1, 0, 0)}
        {evaluateGuess("CLOUD", "IRATE") shouldBe listOf(0, 0, 0, 0, 0)}
    }


})
