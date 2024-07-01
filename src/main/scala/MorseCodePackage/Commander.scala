package MorseCodePackage

import scala.io.StdIn

object Commander {
  val translator = new MorseCodeTranslator()
  val translatorService = new TranslatorService(translator: MorseCodeTranslator)


  class Command {
    def intro(): Unit = {

      println("What is your name ")
      val greetings = StdIn.readLine()

      println("Please select which service you require" +
        "\n0. Exit" +
        "\n1. Convert from english alphabet to morse" +
        "\n2. Convert Morse Code to English"
      )
      val desiredOption = StdIn.readLine()
      desiredOption match {
        case "0" => println("Exiting...") // Print a message indicating exit
        case "1" => englishToMorseCode()
        case "2" => morseCodeToEnglish()
        case _ =>
          println("Invalid input")
          intro() // If input is invalid, recursively call intro() to prompt again
      }
    }
  }

    def englishToMorseCode(): Unit = {
      println("Please enter your character or string to translate")
      val text = StdIn.readLine()

      val translatedText = if (text.length > 1) {
//        translator.stringToMorse(text)
        translatorService.validateStringToMorse(text)
      } else {
        translator.charToMorse(text.head)
      }

      println(s"Translated text: $translatedText")
    }

    def morseCodeToEnglish(): Unit = {
      println("Please enter your character or string to translate")
      val text = StdIn.readLine()
//      val translatedText = translator.morseToString(text)
      val translatedText = translatorService.validateMorseToString(text)
      println(s"Translated text: $translatedText")
    }

  def main(args: Array[String]): Unit = {
    val command = new Command()
    command.intro()
  }

}
