import scala.annotation.tailrec

@main
def main(): Unit = {

  val h = () => { print("H") }
  val o: () => Unit = () => { print("O") }

  h()
  e()
  ll()
  o()
}

def e(): Unit = print("E")

def ll(): Unit = {
  def l(): Unit = {
    print("L")
  }

  l()
  l()
}
