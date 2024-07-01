package MorseCodePackage

case class InvalidInputException(message: String) extends Exception(message)

class TranslatorService(morseCodeTranslator: MorseCodeTranslator) {

  def validateStringToMorse(string: String): String = {
  val pattern = "^[A-Za-z ]+$"  // Allows alphabetic characters and spaces

    val (morseCode, originalString) = morseCodeTranslator.stringToMorse(string)

    originalString.trim match {
      case "" => "No valid string"
      case str if !str.matches(pattern) =>
        throw new InvalidInputException("Input must contain only alphabetic characters and spaces")
      case _ => s"This is your translated string $morseCode from $originalString"
    }
  }



  def validateMorseToString(morseCode: String): String = {
    val morsePattern = "[\\.\\- ]+" // Only allow morse code

    // The following call assumes that morseToString returns a tuple (string, originalMorseCode)
    val (string, originalMorseCode) = morseCodeTranslator.morseToString(morseCode)

    originalMorseCode match {
      case "" => "No valid string"
      case morse if !morse.matches(morsePattern) =>
        throw InvalidInputException("Input must contain only Morse code characters (dots, dashes, and spaces)")
      case _ => s"This is your translated string: $string, from Morse code: $originalMorseCode"
    }
  }

}
