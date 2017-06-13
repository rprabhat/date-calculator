
sealed trait Error
case class ParsingError(error: String) extends Error
case class ValidationError(error: String) extends Error
