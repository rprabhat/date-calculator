import org.scalatest._
import DateCalculator._


class DateCalculatorSpec extends FlatSpec with ShouldMatchers {

  "Sample test cases" should " match expected output" in {

    diff( Date(1972, 11, 7), Date(1972, 11, 8)) shouldEqual 0
    diff( Date(2000, 1, 1), Date(2000, 1, 3)) shouldEqual 1
    diff( Date(1983, 6, 2), Date(1983, 6, 22)) shouldEqual 19
    diff( Date(1984, 7, 4), Date(1984, 12, 25)) shouldEqual 173
    diff( Date(1989, 1, 3), Date(1983, 8, 3)) shouldEqual 1979
  }
}