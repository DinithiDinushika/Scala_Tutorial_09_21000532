class Rational(p: Int, q: Int) {
  require(denominator > 0, "Denominator must be greater than 0")

  def numerator = p
  def denominator = q

  def neg = new Rational(-this.numerator, this.denominator)

  override def toString(): String = numerator + "/" + denominator

}

object Q1 {
  def main(args: Array[String]) {

    val n1 = new Rational(1,2)
    println(n1.neg)
  }

}
