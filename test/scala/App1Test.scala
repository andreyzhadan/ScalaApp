import org.scalatest.FunSuite

/**
 * Created by andrewzhadan on 9/2/14.
 */
class App1Test extends FunSuite {

  val app1 = new App1

  test("hello") {
    assert(app1.sayHello("Scala") == "Hello, Scala!")
  }
}

