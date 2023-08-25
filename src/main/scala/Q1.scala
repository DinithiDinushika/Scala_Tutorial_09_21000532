object Q1 {
  def main(args: Array[String]): Unit = {

    val n1 = new Rational(1,2)
    println("Rational number is: "+ n1)
    println("Negated rational number is: " + n1.neg)
  }

  class Rational(p: Int, q: Int) {
    require(q > 0, "Denominator must be greater than 0")

    def numerator = p

    def denominator = q

    def neg = new Rational(-this.numerator, this.denominator)

    override def toString(): String = numerator + "/" + denominator

  }

}
