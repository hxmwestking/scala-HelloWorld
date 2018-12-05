package demo

import scala.concurrent.ExecutionContext


object MultipleParameterLists extends App {

//    def foldLeft[B](z: B)(op: (B, B) => B): B

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)
//  val res = numbers.sum
  println(res) // 55

  // SINGLE FUNCTIONAL PARAMETER
//  val res2 =numbers.foldLeft(0, {(m: Int, n: Int) => m + n})
//  println(res2) // 55

  val res3: Int = numbers.foldLeft(0)(_+_)
  println(res3)

  val numberFunc = numbers.foldLeft(List[Int]())_

  val squares = numberFunc((xs, x) => xs:+ x*x)
  println(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs:+ x*x*x)
  println(cubes.toString())  // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)


  numbers.foldLeft(0)((sum, item) => sum + item) // Generic Form
  numbers.foldRight(0)((sum, item) => sum + item) // Generic Form

  numbers.foldLeft(0)(_+_) // Curried Form
  numbers.foldRight(0)(_+_) // Curried Form

  (0 /: numbers)(_+_) // Used in place of foldLeft
  (numbers :\ 0)(_+_) // Used in place of foldRight

  // IMPLICIT PARAMETERS

  def execute(arg: Int)(implicit ec: ExecutionContext) = ???
}


