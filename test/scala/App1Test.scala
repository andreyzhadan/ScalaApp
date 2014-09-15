import org.scalatest.FunSuite

/**
 * Created by andrewzhadan on 9/2/14.
 */
class App1Test extends FunSuite {
  val app1 = new App1

  /**
   * Exercise 1
   */
  test("pascal: col=0,row=2") {
    assert(app1.pascal(0, 2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(app1.pascal(1, 2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(app1.pascal(1, 3) === 3)
  }

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(app1.balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(app1.balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!app1.balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!app1.balance("())(".toList))
  }

  test("countChange: example given in instructions") {
    assert(app1.countChange(4, List(1, 2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(app1.countChange(300, List(5, 10, 20, 50, 100, 200, 500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(app1.countChange(301, List(5, 10, 20, 50, 100, 200, 500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(app1.countChange(300, List(500, 5, 50, 100, 20, 200, 10)) === 1022)
  }
}

