package example.SolutionWithoutCRUDArch

import scala.util.Try


/* Tanken er å lære seg forskjellen mellom metode og funksjon. Function 1 function2 etc i scala. Lære sentrale begreper og forstå hvoran det fungerer i praksis
* Introduserer grunnbegrepene
* 1. Anonyme funsjoner
* 2. Andre grads funksjoner
* 3. val
* 4. pattern patch
*
*  Tenker at calculator blir brukt videre i bank eksempelet
* */


/* Slik ser kanditatene Calculator Vi skriver hint og beskrivelse til hver oppgave*/
/*trait Calculator{
  def debugMath[A: Number](a: A, b: A, f: (A, A) => A): A = {
    val res = f(a, b)
    println(s"Got params $a $b, result of function is $res")
    res
  }

  def sum(a:Int,b:Int):Int = ???
  def minus(a:Double,b:Double) = ???
  def multiply(a:Int, b:Int) = ???
  def devide(a:Int, b:Int) = ???

  /* Todo make anonomous functions so you can pass it to debugMath.
  */
  val sumFunc = ???
  val minusFunc = ???
  val multiplyFunc = ???
  val devideFunc = ???

  def handleTwoNumbers(f : (Int, Int) => Int) = ???

  /* Todo Del 2 utvidelse make it generic - vanskelig */
  def debugMathExtension[A: Number](f: A => A, nums: A*): A = ???
  def sumSequence(a:Int*):Int = ???
  def handleAnyNumber[A: Number](f: A => A, nums: A*): A = ???


  // Todo Call debug - optional, if you want a printout in console
  debugMath(2, 3, sum)
  debugMathExtension(sumSequence, 1, 2, 3)

}

*/

/*  Fasit: må pusses på */
trait Calculator{
  def debugMath[A: Number](a: A, b: A, f: (A, A) => A): A = {
    val res = f(a, b)
    println(s"Got params $a $b, result of function is $res")
    res
  }

  def sum(a:Double,b:Double):Double = a + b
  def minus(a:Double,b:Double) = a - b
  def multiply(a:Double, b:Double) = a * b
  def devide(a:Double, b:Double) = Try(a/b).recover{case _: ArithmeticException => 0 }.get

  val sumFunc: (Double, Double) => Double = sum
  val minusFunc: (Double,Double) => Double = minus
  val multiplyFunc: (Double, Double)  => Double = multiply
  val devideFunc: (Double,Double) => Double = devide

  def handleTwoNumbers(f : (Double, Double) => Double, a:Double,b:Double) = f(a, b)

  /* Todo utvidelse make it generic - Hard*/
  def debugMathExtension[A: Number](f: A => A, nums: A*): A = {
    val res = f(nums)
    println(s"Got params $nums, result of function is $res")
    res
  }
  def sumSequence(a:Int*):Int = a.sum
  def sumSequence1(a:Int*):Int = a.foldLeft(0)(_+_)
  def handleAnyNumber[A: Number](f: A => A, nums: A*): A = f(nums)

  // Todo Call debug - optional, if you want a printout in console
  debugMath(2, 3, sumFunc)
  debugMath(3,5, minusFunc)
  debugMath(3,3,multiplyFunc)
  debugMath(1,4, devideFunc)
  debugMathExtension(sumSequence, 1, 2, 3)

}



//handleTwoNumbers(sum2)
//handleTwoNumbers(devide)