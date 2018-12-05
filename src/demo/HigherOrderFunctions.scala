package demo

object HigherOrderFunctions extends App {

  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
  val newSalaries2 = salaries.map(x => x * 2) // List(40000, 140000, 80000)
  val newSalaries3 = salaries.map(_ * 2) // List(40000, 140000, 80000)

  newSalaries.foreach(i => println(i))
  newSalaries2.foreach(i => println(i))
  newSalaries3.foreach(i => println(i))

  // Coercing methods into functions
  case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

    private def convertCtoF(temp: Double) = temp * 1.8 + 32

    def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  }

  // Functions that accept functions

  object SalaryRaiser {

    def smallPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * 1.1)

    def greatPromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      salaries.map(salary => salary * salary)
  }

  object SalaryRaiserImprove {

    private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
      salaries.map(promotionFunction)

    def smallPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * 1.1)

    def bigPromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * math.log(salary))

    def hugePromotion(salaries: List[Double]): List[Double] =
      promotion(salaries, salary => salary * salary)
  }

  // Functions that return functions

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }

  val domainName = "www.example.com"
  def getURL = urlBuilder(ssl=true, domainName)
  val endpoint = "users"
  val query = "id=1"
  val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
  println(s"url = $url")

}
