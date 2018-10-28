package example.SolutionWithoutCRUDArch

import scala.util.Try


/* Tanken er å lære seg at det er enkelt å sende funsjoner rundt. Trenger ikke arv. Lære sentrale begreper og forstå hvoran det fungerer i praksis
* Introduserer grunnbegrepene
* 1. Anonyme funsjoner
* 2. Andregradsfunksjoner
* 3. val
* 4 Se at det å kombinere funksjoner er enkelt
*
*  Tenker at calculator blir brukt videre i bank eksempelet
* */



trait Calculator{
  def debugMath[A](a: A, b: A, f: (A, A) => A): A = {
    val res = f(a, b)
    println(s"Got params $a $b, result of function is $res")
    res
  }

  def sum(a:Double,b:Double):Double = ???
  def minus(a:Double,b:Double):Double = ???
  def multiply(a:Double, b:Double):Double = ???
  def devide(a:Double, b:Double):Double = ???

  /* Todo make anonomous functions and pass it to debugMath to test your code.
  */
  lazy val sumFunc: (Double, Double) => Double = ???
  lazy val minusFunc: (Double, Double) => Double = ???
  lazy val multiplyFunc: (Double, Double) => Double = ???
  lazy val devideFunc: (Double, Double) => Double = ???

  /* Todo Del 2 utvidelse make it generic for numbers - hard */
  def handleAnyNumber[A](f: Seq[A] => A, nums: A*): A = f(nums)
  def debugMathExtension[A](f: A => A, nums: A*): A = ???
  def sumSequence(a:Int*):Int = ???

  // Todo Call debug - optional, if you want a printout in console
  debugMath(2.0, 3.0, sumFunc)
//  debugMathExtension(sumSequence, List(1, 2, 3))

}

