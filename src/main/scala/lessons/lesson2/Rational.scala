package lessons.lesson2

import scala.annotation.tailrec

/**
 * Created by andrewzhadan on 9/15/14.
 */
//primary constructor
class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")

  def this(x: Int) = this(x, 1)

  @tailrec
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  private val g = gcd(x, y)
  val numer = x / g
  val denom = y / g

  def <(that: Rational): Boolean = numer * that.numer < that.numer * denom

  def max(that: Rational) = if (this < that) that else this


  def +(that: Rational): Rational = {
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)
  }

  def unary_- : Rational = new Rational(-numer, denom)

  def -(that: Rational) = this + -that

  override def toString = numer + "/" + denom
}

