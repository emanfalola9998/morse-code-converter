import MorseCodePackage.MorseCodeTranslator
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.BeforeAndAfter

class MorseCodeTranslatorTest extends AnyFunSpec with BeforeAndAfter {
  var morseCodeTranslator: MorseCodeTranslator = _

  before{
    // Create the MOCK
    morseCodeTranslator = new MorseCodeTranslator
  }

  describe("MorseCodeTranslator"){
    it("should convert a character to morse code"){
      // accessing the method charToMorse
      val convertA  = morseCodeTranslator.charToMorse('a')

      assert(convertA == ".-")
    }

    it("should convert a string to morse code"){
      val convertSentence = morseCodeTranslator.stringToMorse("emmanuel")

      assert(convertSentence == (". -- -- .- -. ..- . .-..","emmanuel"))
    }

    it("should convert morse code to string"){
      val convertSentence = morseCodeTranslator.morseToString(". -- -- .- -. ..- . .-..")

      assert(convertSentence == ("EMMANUEL",". -- -- .- -. ..- . .-.."))
    }
  }

}
