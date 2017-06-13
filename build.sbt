name := "DateCalculator"

version := "1.0"

scalaVersion := "2.11.0"

libraryDependencies ++= Seq(
  // UTILS
  "org.scala-lang.modules"              %% "scala-parser-combinators" % "1.0.4",
  // TESTS
  "org.scalatest"                       %% "scalatest"                % "2.2.4"  % "test",
  "org.scalacheck"                      %% "scalacheck"               % "1.12.2" % "test"
)
    