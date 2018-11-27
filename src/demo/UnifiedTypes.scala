package demo

object UnifiedTypes extends App {

  // Scala Type Hierarchy
  println("Scala Type Hierarchy\n============")
  val list: List[Any] = List(
    "a string",
    732, // an integer
    'c', // a character
    true, // a boolean value
    () => "an anonymous function returning a string"
  )

  list.foreach(element => println(element))

  // Type Casting
  println("Type Casting\n============")
  val x: Long = 987654321
  val y: Float = x // 9.8765434E8 (note that some precision is lost in this case)
  println(s"x: $x ,y: $y")

  val face: Char = '☺'
  val number: Int = face // 9786
  println(s"face: $face ,number: $number")

  val x1: Long = 987654321
  val y1: Float = x1 // 9.8765434E8
  //  val z1: Long = y1  // Does not conform
  println(s"x1: $x1 ,y1: $y1")

  // Nothing and Null
  /*
  Nothing is a subtype of all types, also called the bottom type. There is no value that has type Nothing.
  A common use is to signal non-termination such as a thrown exception, program exit, or an infinite loop
  (i.e., it is the type of an expression which does not evaluate to a value, or a method that does not return normally).

  Null is a subtype of all reference types (i.e. any subtype of AnyRef).
  It has a single value identified by the keyword literal null.
  Null is provided mostly for interoperability with other JVM languages and should almost never be used in Scala code.
  We’ll cover alternatives to null later in the tour.
  */
}
