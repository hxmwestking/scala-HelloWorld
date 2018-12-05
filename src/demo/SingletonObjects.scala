package demo

import scala.math._

object SingletonObjects extends App {

  // An object is a class that has exactly one instance. It is created lazily when it is referenced, like a lazy val.
  // As a top-level value, an object is a singleton.
  // As a member of an enclosing class or as a local value, it behaves exactly like a lazy val.

  // Defining a singleton object

  println("Defining a singleton object\n============")

  object Logger {
    def info(message: String): Unit = println(s"INFO: $message")
  }

  // The method info can be imported from anywhere in the program.
  // Creating utility methods like this is a common use case for singleton objects.
  // Let’s see how to use info in another package:
  class Project(name: String, daysToComplete: Int)

  class Test {
    val project1 = new Project("TPS Reports", 1)
    val project2 = new Project("Website redesign", 5)
    Logger.info("Created projects")  // Prints "INFO: Created projects"
  }

  // Companion objects

  println("Companion objects\n============")

  // An object with the same name as a class is called a companion object.
  // Conversely, the class is the object’s companion class.
  // A companion class or object can access the private members of its companion.
  // Use a companion object for methods and values which are not specific to instances of the companion class.
  case class Circle(radius: Double) {
    import Circle._
    def area: Double = calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  val circle1 = new Circle(5.0)

  println(circle1.area)

  // The companion object can also contain factory methods:
  class Email(val username: String, val domainName: String)

  object Email {
    def fromString(emailString: String): Option[Email] = {
      emailString.split('@') match {
        case Array(a, b) => Some(new Email(a, b))
        case _ => None
      }
    }
  }

  val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
  scalaCenterEmail match {
    case Some(email) => println(
      s"""Registered an email
         |Username: ${email.username}
         |Domain name: ${email.domainName}
     """)
    case None => println("Error: could not parse email")
  }

  // Notes for Java programmers

  println("Notes for Java programmers\n============")

  // static members in Java are modeled as ordinary members of a companion object in Scala.
  // When using a companion object from Java code, the members will be defined in a companion class with a static modifier.
  // This is called static forwarding. It occurs even if you haven’t defined a companion class yourself.

}
