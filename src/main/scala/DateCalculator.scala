import DateParser._



object DateCalculator {

  def diff(from: Date, to: Date): Int = {

    if (from > to) {
      diff(to, from)
    } else {

      val months = for {
        year <- from.year to to.year
        mm <- year match {
         case _ if from.year == to.year => from.month to to.month
         case from.year => from.month to 12
         case to.year => 1 to to.month
         case _ => 1 to 12
        }
      } yield (year, mm)

      months.foldLeft[Int](0) {
        (z: Int, t: (Int, Int)) =>
          val days = t match {
               case _ if from.year == to.year && from.month == to.month => to.day - from.day - 1
               case (from.year, from.month) => Month(from.year, from.month).numDays - from.day
               case (to.year, to.month) => to.day - 1
               case _ => Month(t._1, t._2).numDays
          }
          days + z
      }
    }
  }

  def main(args: Array[String]) {

    if (args.length != 2)
      println("Usage: sbt \"run-main DateCalculator <YYYY-MM-DD> <YYYY-MM-DD>\"")
    else {
      val result = for {
        from <- parse(args(0)).right
        to <- parse(args(1)).right
      } yield diff(from, to)

      result match {
        case Right(d) => println(d)
        case Left(err) => println(err)
      }

    }

  }

}


