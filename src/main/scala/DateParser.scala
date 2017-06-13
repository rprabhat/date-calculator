import scala.util.parsing.combinator.RegexParsers
import DateValidator._

object DateParser extends RegexParsers {

  def year: Parser[Int] = """\d{1,4}""".r ^^ { _.toInt }
  def other: Parser[Int] = """\d{2}""".r ^^ { _.toInt }

  def dateParser: Parser[(Int, Int, Int)] =
    year ~ ("-" ~> other) ~ ("-" ~> other)  ^^ {
      case year ~ month ~ day  => (year, month, day)
    }

  def parse(dateString: String) =
    parseAll(dateParser, dateString) match {
    case Success((yyyy, mm, dd), _) => validateDate(yyyy, mm, dd)
    case Failure(msg, _) => Left(ParsingError("Invalid Input " + msg))
    case Error(msg, _) => Left(ParsingError("Parsing Error " + msg))
  }
}



