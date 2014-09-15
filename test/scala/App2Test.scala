package scala

import org.scalatest.FunSuite
import lessons.lesson2.App2

/**
 * Created by andrewzhadan on 9/2/14.
 */
class App2Test extends FunSuite {
  val app2 = new App2
  test("product test") {
    assert(app2.product(0, 2) === 0)
    assert(app2.product(1, 3) === 6)
    assert(app2.product(3, 1) === 1)
  }

  test("product2 test") {
    assert(app2.product2(x => x)(0, 2) === 0)
    assert(app2.product2(x => x)(1, 3) === 6)
    assert(app2.product2(x => x)(3, 1) === 1)
  }

  test("sum4 test") {
    assert(app2.sum4(x => x)(0, 2) === 0)
    assert(app2.sum4(x => x)(1, 4) === 10)
    assert(app2.sum4(x => x)(3, 1) === 0)
  }

  test("factorial test") {
    assert(app2.factorial(2) === 2)
    assert(app2.factorial(3) === 6)
    assert(app2.factorial(5) === 120)
  }
}

