package workshop

import scala.util.Try

trait Calculator{
  def debugMath[A](a: A, b: A, f: (A, A) => A): A = {
    val res = f(a, b)
    println(s"Got params $a $b, result of function is $res")
    res
  }

  def sum(a:Double, b:Double):Double = a + b
  def minus(a:Double, b:Double): Double = a - b
  def multiply(a:Double, b:Double): Double = a * b
  def devide(a:Double, b:Double): Double = Try(a/b).recover{case _: ArithmeticException => 0d }.get

  val sumFunc: (Double, Double) => Double = sum
  val minusFunc: (Double, Double) => Double = minus
  val multiplyFunc: (Double, Double)  => Double = multiply
  val devideFunc: (Double, Double) => Double = devide

  def handleTwoNumbers(f : (Double, Double) => Double, a:Double, b:Double) = f(a, b)

  /* Todo utvidelse make it generic - Hard*/
  def debugMathExtension[A, B](f: Seq[A] => B, nums: A*): B = {
    val res = f(nums)
    println(s"Got params $nums, result of function is $res")
    res
  }
  def sumSequence(a: Int*): Int = a.sum
  def sumSequenceAlt1(a: Int*): Int = a.foldLeft(0)(_+_)
  def handleAnyNumber[A](f: Seq[A] => A, nums: A*): A = f(nums)

  // Todo Call debug - optional, if you want a printout in console
  debugMath(2.0, 5.0, sumFunc)
  debugMath(2d, 3d, sumFunc)
  debugMath(3d, 5d, minusFunc)
  debugMath(3d, 3d,multiplyFunc)
  debugMath(1d, 4d, devideFunc)
  debugMathExtension(sumSequence, 1, 2, 3)

}