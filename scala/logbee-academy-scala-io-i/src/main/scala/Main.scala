import scala.io.StdIn.readLine

@main
def main(): Unit = {

  println()

  val name = readLine("Enter your name: ")

  println(s"Hello, $name")

  readLine("\n<<press enter>>")
}
