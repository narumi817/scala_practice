class Printer(x: Int) {
  def print(): Unit = println(x)
}
(new Printer(1)).print()

// protected
class Super {
  protected def puts(message: String): Unit = {
    println(message)
  }
}

class Sub extends Super {
  def sub(): Unit = {
    puts("print")
  }
}

// lazy
class Circle(x: Int, y: Int, radius: Int) {
  lazy val area: Double = {
    println("面積を計算します")
    radius * radius * math.Pi
  }
}

val c = new Circle(0, 0, 5)

c.area
c.area
