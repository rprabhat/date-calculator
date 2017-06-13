

  case class Date(year: Int, month: Int, day: Int) extends Ordered[Date] {

    def compare(that: Date) = {
      this.year - that.year match {
        case 0 => this.month - that.month match {
          case 0 => this.day - that.day
          case n => n
        }
        case n => n
      }
    }

  }


  object Year {

    trait Year {
      def yyyy: Int
    }

    case class LEAP_YEAR(yyyy: Int) extends Year

    case class NON_LEAP_YEAR(yyyy: Int) extends Year

    def apply(yyyy: Int) = yyyy % 4 match {
      case 0 => LEAP_YEAR(yyyy)
      case 1 | 2 | 3 => NON_LEAP_YEAR(yyyy)
    }

  }

  object Month {

    import Year._

    def apply(yyyy: Int, mm: Int) = mm match {
      case 1 => JAN
      case 2 => Year(yyyy) match {
        case LEAP_YEAR(n) => FEB_LEAP
        case NON_LEAP_YEAR(n) => FEB_NON_LEAP
      }
      case 3 => MAR
      case 4 => APR
      case 5 => MAY
      case 6 => JUN
      case 7 => JUL
      case 8 => AUG
      case 9 => SEP
      case 10 => OCT
      case 11 => NOV
      case 12 => DEC
    }

    trait Month {
      def numDays: Int
    }

    object JAN extends Month {
      def numDays = 31
    }

    object FEB_LEAP extends Month {
      def numDays = 29
    }

    object FEB_NON_LEAP extends Month {
      def numDays = 28
    }

    object MAR extends Month {
      def numDays = 31
    }

    object APR extends Month {
      def numDays = 30
    }

    object MAY extends Month {
      def numDays = 31
    }

    object JUN extends Month {
      def numDays = 30
    }

    object JUL extends Month {
      def numDays = 31
    }

    object AUG extends Month {
      def numDays = 31
    }

    object SEP extends Month {
      def numDays = 30
    }

    object OCT extends Month {
      def numDays = 31
    }

    object NOV extends Month {
      def numDays = 30
    }

    object DEC extends Month {
      def numDays = 31
    }

  }







