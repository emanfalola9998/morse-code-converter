package MorseCodePackage

class MorseCodeTranslator {

  val morseCodeMap: Map[Char, String] = Map(
    'A' -> ".-",    'B' -> "-...",  'C' -> "-.-.",  'D' -> "-..",   'E' -> ".",
    'F' -> "..-.",  'G' -> "--.",   'H' -> "....",  'I' -> "..",    'J' -> ".---",
    'K' -> "-.-",   'L' -> ".-..",  'M' -> "--",    'N' -> "-.",    'O' -> "---",
    'P' -> ".--.",  'Q' -> "--.-",  'R' -> ".-.",   'S' -> "...",   'T' -> "-",
    'U' -> "..-",   'V' -> "...-",  'W' -> ".--",   'X' -> "-..-",  'Y' -> "-.--",
    'Z' -> "--..", '1' -> ".----", '2' -> "..---", '3' -> "...--", '4' -> "....-",
    '5' -> ".....", '6' -> "-....", '7' -> "--...", '8' -> "---..", '9' -> "----.",
    '0' -> "-----"
  )

  def charToMorse(char: Char): String = {
    morseCodeMap.get(char.toUpper) match {
      case Some(result) => result
      case None => "Invalid character"
    }
  }

  def stringToMorse(string: String): (String,String) = {
    val morseCode = string.toUpperCase.map {
      case ' ' => " " // This line checks if the current character is a space ' '. If it is, it maps it to a single space " ". This ensures that spaces in the input string are preserved in the output Morse code string.
      case char => morseCodeMap.getOrElse(char, "Invalid text or character in string")
    }.mkString(" ")

    (morseCode, string)
  }
//
  def morseToString(morseCode: String): (String,String) = {
    val string = morseCode.split("   ").map { // Split by three spaces to handle word separation
      word =>
        word.split(" ").map {
          case "" => " " // Handle single space between letters
          case code => morseCodeMap.find(_._2 == code).map(_._1).getOrElse("?") // Convert Morse code back to character
        }.mkString("")
    }.mkString(" ").trim // Join words with a single space and trim extra spaces
    (string, morseCode)
  }

}

// companion objects can also be used to run code via the main method
object MorseCodeTranslatorApp {
  def main(args: Array[String]): Unit = {
    val translator = new MorseCodeTranslator
    val text = "HELLO WORLD"
    val morseCode = translator.stringToMorse(text)
    println(s"Text: $text")
    println(s"Morse Code: $morseCode")
//    val translatedText = translator.morseToString(morseCode)
//    println(s"Translated Text: $translatedText")
  }
}
