package demo

import scala.util.Random

object PatternMatching extends App {

  // Syntax

  // A match expression has a value, the match keyword, and at least one case clause.
  val x: Int = Random.nextInt(10)

  x match {
    case 0 => println("zero")
    case 1 => println("one")
    case 2 => println("two")
    case _ => println("many")
  }

  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(3))  // many
  println(matchTest(1))  // one

  // Matching on case classes

  println("Matching on case classes\n============")

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms))  // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording))  // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

  // Pattern guards

  println("Pattern guards\n============")

  // Pattern guards are simply boolean expressions which are used to make cases more specific.
  // Just add if <boolean expression> after the pattern.

  def showImportantNotification(notification: Notification, importantPeopleInfo: Seq[String]): String = {
    notification match {
      case Email(email, _, _) if importantPeopleInfo.contains(email) =>
        "You got an email from special someone!"
      case SMS(number, _) if importantPeopleInfo.contains(number) =>
        "You got an SMS from special someone!"
      case other =>
        showNotification(other) // nothing special, delegate to our original showNotification function
    }
  }

  val importantPeopleInfo = Seq("867-5309", "jenny@gmail.com")

  val someSms2 = SMS("867-5309", "Are you there?")
  val someVoiceRecording2 = VoiceRecording("Tom", "voicerecording.org/id/123")
  val importantEmail = Email("jenny@gmail.com", "Drinks tonight?", "I'm free after 5!")
  val importantSms = SMS("867-5309", "I'm here! Where are you?")

  println(showImportantNotification(someSms2, importantPeopleInfo))
  println(showImportantNotification(someVoiceRecording2, importantPeopleInfo))
  println(showImportantNotification(importantEmail, importantPeopleInfo))
  println(showImportantNotification(importantSms, importantPeopleInfo))

  // Matching on type only

  println("Matching on type only\n============")

  // def goIdle has a different behavior depending on the type of Device.
  // This is useful when the case needs to call a method on the pattern.
  // It is a convention to use the first letter of the type as the case identifier (p and c in this case).

  abstract class Device
  case class Phone(model: String) extends Device{
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  // Sealed classes

  println("Sealed classes\n============")

  sealed abstract class Furniture
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

}
