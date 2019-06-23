// apply
object Add {
  def apply(x: Int, y: Int): Int = x + y
}
Add.apply(1,2)
Add(1,2)
Add.apply(2,4)
Add(2,4)

// update
val x = Array(1,2,3,4,5)
x(0)
x.apply(0)
x(0) = 5
x
x.update(0, 4)
x

// unary_
class MyString(val content: String) {
  def unary_! : String = "!" + content
}
val s = new MyString("Taro")
!s
s.unary_!