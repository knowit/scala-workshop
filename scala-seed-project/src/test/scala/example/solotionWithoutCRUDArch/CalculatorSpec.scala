package example.solotionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.Calculator
import org.scalatest.{Matchers, WordSpec}


 class CalculatorSpec extends WordSpec with Matchers with Calculator {

    "Adding 1 by 5" should {
      "be 6" in {
        sumFunc(1.0, 5.0) === 6.0
      }
    }

    "Diffransiate 3 by 5" should {
      "be 2" in {
        minusFunc(3, 5) === 2
      }
    }

    "Multiply 3 with 4 " should {
      "be 12" in {
        minusFunc(3, 5) === 12
      }
    }

    "Devide 12 by 4 " should {
      "be 3" in {
        minusFunc(12, 4) ===  3
      }
    }

    "Devide 6 by 0 " should {
      "be result in ArithmeticException" in {
        an[ArithmeticException] should be thrownBy devideFunc(6,0)
      }
    }

}
