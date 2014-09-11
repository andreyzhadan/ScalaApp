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


  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def sum2(f: Int => Int, a: Int, b: Int): Int = {
    @tailrec
    def tailSum(a: Int, acc: Int): Int = {
      if (a > b) acc else tailSum(a + 1, acc + f(a))
    }
    tailSum(a, 0)
  }

  def sumInts(a: Int, b: Int) = sum2(x => x, a, b)

  def sumCubes(a: Int, b: Int) = sum2(x => x * x * x, a, b)

}
