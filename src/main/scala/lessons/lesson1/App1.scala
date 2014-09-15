import scala.annotation.tailrec

/**
 * Created by andrewzhadan on 8/9/14.
 */
class App1 {
  def sayHello(name: String) {
    print("Hello -> ")
    s"Hello, $name!"
  }

  def abs(x: Double) = {
    //    print("Abs for " + x + "-> ")
    if (x >= 0) x else -x
  }

  //y - by name
  def and(x: Boolean, y: => Boolean) = {
    if (x) y else false
  }

  def loop: Boolean = {
    print("loop")
    loop
  }

  def factorial(n: Int): Int = {
    if (n <= 1) 1 else n * factorial(n - 1)
  }

  def factorial2(n: Int): Int = {
    @tailrec
    def tailFactorial(result: Int, n: Int): Int = {
      if (n <= 1) result else tailFactorial(result * n, n - 1)
    }
    tailFactorial(1, n)
  }

  def sqrt(x: Double) = {
    def isGoodEnough(guess: Double) = {
      abs(guess * guess - x) / x < 0.001
    }

    def impove(guess: Double) = {
      (guess + x / guess) / 2
    }

    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess
      else sqrtIter(impove(guess))
    }

    sqrtIter(1.0)
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c, r - 1) + pascal(c - 1, r - 1)
  }


  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def calc(chars: List[Char], bal: Int): Int = {
      if (chars.isEmpty || bal < 0) bal
      else {
        calc(chars.tail,
          chars.head match {
            case '(' => bal + 1
            case ')' => bal - 1
            case _ => bal
          })
      }
    }
    calc(chars, 0) == 0
  }


  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    def count(m: Int, n: Int): Int = {
      // If n is 0 then there is 1 solution (do not include any coin)
      if (n == 0) 1
      else
      // If n is less than 0 then no solution exists
      if (n < 0) 0
      // If there are no coins and n is greater than 0, then no solution exist
      else
      if (m <= 0 && n >= 1) 0
      // count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
      else
        count(m - 1, n) + count(m, n - coins(m - 1))
    }
    count(coins.size, money)
  }
}
