package demo

object GenericClasses extends App {

  // Defining a generic class

  println("Defining a generic class\n============")

  // Generic classes take a type as a parameter within square brackets [].
  // One convention is to use the letter A as type parameter identifier, though any parameter name may be used.

  class Stack[A] {
    private var elements: List[A] = Nil
    def push(x: A) { elements = x :: elements }
    def peek: A = elements.head
    def pop(): A = {
      val currentTop = peek
      elements = elements.tail
      currentTop
    }
  }

  // Usage

  println("Usage\n============")

  // To use a generic class, put the type in the square brackets in place of A.
  val stack = new Stack[Int]
  stack.push(1)
  stack.push(2)
  println(stack.pop)  // prints 2
  println(stack.pop)  // prints 1

  class Fruit
  class Apple extends Fruit
  class Banana extends Fruit

  val stack2 = new Stack[Fruit]
  val apple = new Apple
  val banana = new Banana

  stack2.push(apple)
  stack2.push(banana)

}
