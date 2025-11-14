import io.kotest.assertions.withClue
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@Suppress("unused")
class WordleTest : StringSpec({
    "Words of 5 letters that are in the word list should be valid" {
        withClue("Word=IRATE") { isValid("IRATE") shouldBe true}
        withClue("Word=CLOUD") { isValid("Cloud") shouldBe true}
        withClue("Word=APPLE") { isValid("apple") shouldBe true}
    }

    "Words of not length 5 should be invalid" {
        withClue("Word=SURGERY") { isValid("Surgery") shouldBe false}
        withClue("Word=COMPANY") { isValid("Company") shouldBe false}
    }

    "Words of 5 letters not in the word list should be invalid" {
        withClue("Word=SILIE") { isValid("SILIE") shouldBe false}
        withClue("Word=TREE8") { isValid("Treee") shouldBe false}
    }
})
