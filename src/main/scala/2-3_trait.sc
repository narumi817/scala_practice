trait Namable {
  val name: String
  def display(): Unit = println(name)
}

class Employee(val name: String) extends AnyRef with Namable

val taro = new Employee("taro")
taro.display()

// foreachに関数fを渡すと、Enumerableをmix-inしたクラスを「列挙可能な」クラスとみなして、そこに所属する要素を順番にfに渡して呼び出す
// そのほかのメソッドは全てforeachを呼び出して定義されているので、foreachを実装することでほかのメソッドも手に入る
import scala.collection.mutable.Buffer
trait Enumerable[A] {
  def foreach[B](fun: A => B): Unit

  // それぞれの要素にfを適用し、そこから集められたListを返す
  final def map[B](f: A => B): List[B] = {
    var members = Buffer.empty[B]
    foreach { m =>
      members += f(m)
    }
    members.toList
  }

  // それぞれの要素にpを適用し、pがtrueを返す要素だけからなるListを返す
  final def filter(p: A => Boolean): List[A] = {
    val members = Buffer.empty[A]
    foreach { m =>
      if (p(m)) members += m
    }
    members.toList
  }

  // 要素をListとして返す
  final def toList: List[A] = {
    val members = Buffer.empty[A]
    foreach { m =>
      members  += m
    }
    members.toList
  }
}

class Staff(val name: String, val age: Int)

class Shop(val name: String) extends AnyRef with Enumerable[Staff] with Namable {
  private[this] val staffs: List[Staff] =
    List(new Staff("太郎", 20), new Staff("花子", 30))

  // foreachの実装をする
  override def foreach[B](f: Staff => B): Unit = staffs.foreach(f)
}

val shop = new Shop("お店")
shop.filter(x => x.age > 20) // 20歳以上の店員のListを作る
shop.filter(_.age > 20)      // 上と一緒
shop.map(x => x.name) // 店員の名前のリストを作る
shop.map(_.name)      // 上と一緒
shop.toList // 店員のリストを取得
shop.display() // 店名の表示

