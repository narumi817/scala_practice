case class Point(val x: Int, val y: Int)

val p = Point(10, 20)
p match {
  case Point(x, y) => {
    println(x)
    println(y)
  }
}