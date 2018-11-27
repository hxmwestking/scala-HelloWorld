package demo

import scala.collection.mutable.ArrayBuffer

object Traits extends App {

  // Defining a trait
  println("Defining a trait\n============")
  trait HairColor

  trait Iterator[A] {
    def hasNext: Boolean
    def next(): A
  }

  // Using traits
  println("Using traits\n============")

  class IntIterator(to: Int) extends Iterator[Int] {
    private var current = 0
    override def hasNext: Boolean = current < to
    override def next(): Int =  {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }
  }

  val iterator = new IntIterator(2)
  println(iterator.next())  // returns 0
  println(iterator.next())  // returns 1

  // Subtyping
  println("Subtyping\n============")

  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet
  class Dog(val name: String) extends Pet

  val dog = new Dog("Harry")
  val cat = new Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))  // Prints Harry Sally
}
