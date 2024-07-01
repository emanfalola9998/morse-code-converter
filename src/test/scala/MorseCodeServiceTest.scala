// MOCKITO
import MorseCodePackage.{InvalidInputException, TranslatorService}
import org.mockito.MockitoSugar._
import org.mockito.ArgumentMatchersSugar._
// SCALATEST
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.BeforeAndAfter

class MorseCodeServiceTest extends AnyFunSpec with BeforeAndAfter {
  var mockMorseCodeTranslator: MorseCodePackage.MorseCodeTranslator = _
  var morseCodeService: MorseCodePackage.TranslatorService = _

  before {
    // Create the MOCK
    mockMorseCodeTranslator = mock[MorseCodePackage.MorseCodeTranslator]
    // Dependency Injection
    morseCodeService = new TranslatorService(mockMorseCodeTranslator)
  }

  describe("translator service"){

    it("should return a string with morse code and original string present"){
      val originalString = "hello"
      val morseCode = ".... . .-.. .-.. ---"
      when(mockMorseCodeTranslator.stringToMorse(originalString)).thenReturn((morseCode, originalString))

      val translator = morseCodeService.validateStringToMorse(originalString)

      assert(translator == "This is your translated string .... . .-.. .-.. --- from hello")
    }

    it("should return a string with alphabet characters with the original morse string present "){
      val morseCode = ".... . .-.. .-.. ---"
      val string = "hello"

      when(mockMorseCodeTranslator.morseToString(morseCode)).thenReturn((string,morseCode))

      val translator = morseCodeService.validateMorseToString(morseCode)

      assert(translator == "This is your translated string: hello, from Morse code: .... . .-.. .-.. ---")

    }

    it("should throw an exception when a non-alphabet character is used"){
      val originalString = "hello3"
      val morseCode = ".... . .-.. .-.. ---"


      when(mockMorseCodeTranslator.stringToMorse(originalString)).thenReturn((morseCode, originalString))

      val exception = intercept[InvalidInputException]{
        morseCodeService.validateStringToMorse(originalString)
      }

      assert(exception.getMessage == "Input must contain only alphabetic characters and spaces")
    }

    // need to implement for morseToString

    it("should throw an exception when a alphabet character is used"){
      val orignalMorseCode = ".... . .-.. .-.. ---ab"
      val string = "hello"

      when(mockMorseCodeTranslator.morseToString(orignalMorseCode)).thenReturn((string, orignalMorseCode))

      val exception = intercept[InvalidInputException]{
        morseCodeService.validateMorseToString(orignalMorseCode)
      }

      assert(exception.getMessage == "Input must contain only Morse code characters (dots, dashes, and spaces)")
    }
  }

}
