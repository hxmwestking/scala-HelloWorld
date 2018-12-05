package demo

object Basics extends App {

  // Expressions
  println("Expressions\n==============")
  println(1) // 1
  println(1 + 1) // 2
  println("Hello!") // Hello!
  println("Hello," + " world!") // Hello, world!

  // Values
  println("Values\n==============")
  val x = 1 + 1
  println(x) // 2

  // Variables
  println("Variables\n==============")
  var y = 1 + 1
  y = 3 // This compiles because "y" is declared with the "var" keyword.
  println(x * x) // 9
  val y2: Int = 1 + 1

  // Blocks
  println("Blocks\n==============")
  println({
    val z = 1 + 1
    z + 1
  })

  // Functions
  println("Functions\n==============")
  (x: Int) => x + 1
  val addOne = (x: Int) => x + 1
  println(addOne(1))

  val add = (x: Int, y: Int) => x + y
  println(add(1, 2)) // 3

  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42

  // Methods
  println("Methods\n==============")
  def add1(x: Int, y: Int): Int = x + y
  println(add1(1, 2)) // 3

  def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
  println(addThenMultiply(1, 2)(3)) // 9

  def name: String = System.getProperty("user.name")
  println("Hello, " + name + "!")

  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }
  println(getSquareString(2))

  // Classes
  println("Classes\n==============")
  class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
      println(prefix + name + suffix)

  }

  val greeter = new Greeter("Hello, ", "!")
  greeter.greet("Scala developer") // Hello, Scala developer!

  // Case Classes
  println("Case Classes\n==============")
  case class Point(x: Int, y: Int)

  val point = Point(1, 2)
  val anotherPoint = Point(1, 2)
  val yetAnotherPoint = Point(2, 2)

  if (point == anotherPoint) {
    println(point + " and " + anotherPoint + " are the same.")
  } else {
    println(point + " and " + anotherPoint + " are different.")
  } // Point(1,2) and Point(1,2) are the same.

  if (point == yetAnotherPoint) {
    println(point + " and " + yetAnotherPoint + " are the same.")
  } else {
    println(point + " and " + yetAnotherPoint + " are different.")
  } // Point(1,2) and Point(2,2) are different.

  // Objects
  println("Objects\n==============")
  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }

  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2

  // Traits
  println("Traits\n==============")
  trait Greeter2 {
    def greet(name: String): Unit
  }
  trait Greeter3 {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }

  class DefaultGreeter extends Greeter3

  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter2 {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

  val greeter3 = new DefaultGreeter()
  greeter.greet("Scala developer") // Hello, Scala developer!

  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?

  // Main Method
  println("Main Method\n==============")
  object Main {
    def main(args: Array[String]): Unit =
      println("Hello, Scala developer!")
  }
  Main.main(null)
}
