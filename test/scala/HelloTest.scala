import org.scalatest.FunSuite

/**
 * Created by andrewzhadan on 8/9/14.
 */
class HelloTest extends FunSuite {

  val hello = new Hello

  test("hello") {
    assert(hello.sayHello("Scala") == "Hello, Scala!")
  }

  test("square") {
    assert(hello.square(2) == 4)
  }
}
