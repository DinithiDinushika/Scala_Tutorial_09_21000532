class Rational(p: Int, q: Int) {
  require(q > 0, "Denominator must be greater than 0")

  def numerator = p
  def denominator = q

  def sub(R:Rational) =
    new Rational(
      this.numerator* R.denominator - this.denominator* R.numerator,
      this.denominator* R.denominator)

  override def toString(): String = numerator + "/" + denominator

}

object Q2 {
  def main(args: Array[String]): Unit =  {

    val x = new Rational(3, 4)
    val y = new Rational(5, 8)
    val z = new Rational(2, 7)

    val answer = x.sub(y).sub(z)
    println("x - y - z = "+ answer)

  }

}

