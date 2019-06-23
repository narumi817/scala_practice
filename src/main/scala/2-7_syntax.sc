{
  println("Hello")
  1 + 1
}

def foo(): String = {
  "foo" + "foo"
}

// if式
var num = 40

if (num < 50) {
  true
} else {
  false
}

num = 50
if (num < 50) {
  true
} else {
  false
}

// while式
var i = 1
while (i <= 10) {
  println("i = " + i)
  i = i + 1
}

// for文
for (x <- 1 to 3; y <- 1 until 3) {
  println("x = " + x + " y = " + y)
}

for (x <- 1 to 3; y <- 1 until 3 if x != y) {
  println("x = " + x + " y = " + y)
}

for (e <- List(1, 2, 3)) println(e)

for (e <- List(1, 2, 3)) yield {
  e + 1
}

// match式
val j = 5
j match {
  case 0 => "A"
  case 1 => "B"
  case 2 => "C"
  case 3 => "D"
  case 4 => "E"
  case 5 => "F"
  case _ => "?"
}

val list = List(1, 2, 3, 4, 5)
list match {
  case List(a, b, c, d, e) =>
    println(a, b, c, d, e)
  case _ => println("?")
}

def reverse[A](list: List[A], result: List[A]): List[A] = list match {
  case x :: xs => reverse(xs, x :: result)
  case Nil     => result
}
reverse(List(1 ,2, 3), Nil)

val lst = List("A", "B", "C", "D", "E")
lst match {
  case List("A", b, c, d, e) if b != "B" => {
    println("b = " + b)
    println("c = " + c)
    println("d = " + d)
    println("e = " + e)

  }
  case _ => println("nothing")
}

def last2[A](list: List[A]): A = list match {
  case x :: _ :: Nil => x
  case _ :: xs => last2(xs)
  case _       => sys.error("list should have 2 elements at least.")
}

last2(List(1, 2, 3))
//last2(List(1))

// 例外投げてみる
try {
  throw new RuntimeException("実行時例外")
} catch {
  case e: Exception => println(e.getMessage)
}

def factorial(n: Int) :Int = {
  def f(m: Int, x: Int): Int = if (m == 0) {
    x
  } else {
    f(m - 1, x * m)
  }
  f(n, 1)
}
factorial(4)