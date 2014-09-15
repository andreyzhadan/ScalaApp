package lessons.lesson2

import scala.annotation.tailrec

/**
 * Created by andrewzhadan on 9/13/14.
 */
class App2 {

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

  def sumInts2(a: Int, b: Int) = sum2(x => x, a, b)

  def sumCubes2(a: Int, b: Int) = sum2(x => x * x * x, a, b)

  // : (Int, Int) => currying
  // (Int => Int) =>[(Int, Int) => Int]
  def sum3(f: Int => Int)(a: Int, b: Int): Int = {
    def sumF(a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + sumF(a + 1, b)
    }
    sumF(a, b)
  }

  def sumInts3(a: Int, b: Int) = sum3(x => x)(a, b)

  def sumCubes3(a: Int, b: Int) = sum3(x => x * x * x)(a, b)

  def product(st: Int, end: Int): Int = {
    @tailrec
    def tailProd(curr: Int, acc: Int): Int = {
      if (curr > end) acc else tailProd(curr + 1, acc * curr)
    }
    tailProd(st, 1)
  }

  def factorial(n: Int): Int = {
    product(1, n)
  }

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  def sum4(f: Int => Int)(st: Int, end: Int) = mapReduce(f, (x, y) => x + y, 0)(st, end)

  def product2(f: Int => Int)(st: Int, end: Int) = mapReduce(f, (x, y) => x * y, 1)(st, end)

}
