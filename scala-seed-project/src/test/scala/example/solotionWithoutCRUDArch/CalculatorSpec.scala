package example.solotionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.Calculator
import org.scalatest.{Matchers, WordSpec}

class HopSpec {

  class CalculatorSpec extends WordSpec with Matchers with Calculator {

    "Adding 1 by 5" should {
      "be 6" in {
        handleTwoNumbers(sumFunc,1,5) === 6
      }
    }

    "Diffransiate 3 by 5" should {
      "be 2" in {
        handleTwoNumbers(minusFunc,3,5) === 2
      }
    }

    "Multiply 3 with 4 " should {
      "be 12" in {
        handleTwoNumbers(multiplyFunc,3,5) === 12
      }
    }

    "Devide 12 by 4 " should {
      "be 3" in {
        handleTwoNumbers(multiplyFunc,12,4) === 3
      }
    }

    "Devide 6 by 0 " should {
      "be result in ArithmeticException" in {
        an[ArithmeticException] should be thrownBy handleTwoNumbers(multiplyFunc,12,4)
      }
    }

}
