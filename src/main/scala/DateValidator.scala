

object DateValidator {

  def validateDate(yyyy : Int, mm : Int, dd :Int): Either[ValidationError, Date] =
    for {
      year <- validateYear(yyyy).right
      month <- validateMonth(mm).right
      day <- validateDay(year,month, dd).right
    } yield Date(year, month, day)


  def validateYear(year : Int) : Either[ValidationError, Int] = {
    year match  {
      case _ if year >= 1901 && year <= 2991 => Right(year)
      case _  => Left(ValidationError("Invalid year"))
    }
  }

  def validateMonth(mm : Int) : Either[ValidationError, Int] = {
    mm match  {
      case 1|2|3|4|5|6|7|8|9|10|11|12 => Right(mm)
      case _ => Left(ValidationError("Invalid month"))
    }
  }

  def validateDay(yyyy: Int, mm: Int, day : Int) : Either[ValidationError, Int] = {
    if ( day > Month(yyyy,mm).numDays || day < 1)
      Left(ValidationError("Invalid day for month"))
    else Right(day)
  }
}
