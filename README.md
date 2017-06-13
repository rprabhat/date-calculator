# date-calculator

simple calculator to compute number of days between given dates.

## Implementation

All date components ( year , month ) are modelled as ADT ( case classes ). 
ADT models contraints  like february has 29 days in leap year.

Date difference is calculated using flatmap over range of year and month.

* sbt compile
* sbt test 
* sbt "run-main DateCalculator <YYYY-MM-DD> <YYYY-MM-DD>"