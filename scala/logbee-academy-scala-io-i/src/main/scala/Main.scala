
@main
def main(): Unit = {

  println() // simple println function defined in `scala.predef`

  Console.out.print("Enter your name: ") // Scala Console API
  val name = Console.in.readLine()

  Console.out.println(s"Hello, $name")

  println("\n<<press enter>>")
  Console.in.readLine()

  Console.err.println("Bye Bye") // Print to stdErr
}
