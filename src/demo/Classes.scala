package demo

object Classes extends App {

  // Defining a class
  println("Defining a class\n============")
  class User

  val user1 = new User

  class Point(var x: Int, var y: Int) {

    def move(dx: Int, dy: Int): Unit = {
      x = x + dx
      y = y + dy
    }

    override def toString: String =
      s"($x, $y)"
  }

  val point1 = new Point(2, 3)
  point1.x  // 2
  println(point1)  // prints (2, 3)

  // Constructors
  println("Constructors\n============")
  class Point1(var x: Int = 0, var y: Int = 0)

  val origin = new Point1  // x and y are both set to 0
  val real = new Point1(1)
  println(origin.x)  // prints 1
  println(real.x)  // prints 1

  // Private Members and Getter/Setter Syntax
  println("Private Members and Getter/Setter Syntax\n============")
  class Point2 {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x = _x
    def x_= (newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning
    }

    def y = _y
    def y_= (newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning
    }

    private def printWarning = println("WARNING: Out of bounds")
  }

  val point3 = new Point2
  point3.x = 99
  point3.y = 101 // prints the warning

  class Point3(val x: Int, val y: Int)
  val point4 = new Point3(1, 2)
//  point4.x = 3  // <-- does not compile

  // Parameters without val or var are private values, visible only within the class.
  class Point4(x: Int, y: Int)
  val point5 = new Point4(1, 2)
//  point5.x  // <-- does not compile

}
