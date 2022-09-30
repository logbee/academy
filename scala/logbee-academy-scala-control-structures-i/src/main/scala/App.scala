
@main
def main(): Unit = {

  print("Enter x: ")
  val x = Console.in.readLine().toInt

  print("Enter y: ")
  val y = Console.in.readLine().toInt

  ///////////////////////////////////////////////
  // if statement                              //
  ///////////////////////////////////////////////
  if (x > y) {
    println("x is greater then y")
  }
  else if (x < y) {
    println("x is less then y")
  }
  else {
    println("x is equal y")
  }
  ///////////////////////////////////////////////

  ///////////////////////////////////////////////
  // if expression                             //
  ///////////////////////////////////////////////
  val min = if (x < y) {
    x
  } else {
    y
  }
  ///////////////////////////////////////////////

  println(s"Min value: $min")
  println()

  println("Count to 10")
  println("<press enter>")
  Console.in.readLine()

  ///////////////////////////////////////////////
  // for-loop                                  //
  ///////////////////////////////////////////////
  for (i <- 1 to 10) {
    Console.print(s"$i, ")
  }
  ///////////////////////////////////////////////

  Console.println()
  Console.println()

  println("Count to 10, but only even numbers")
  println("<press enter>")
  Console.in.readLine()

  ///////////////////////////////////////////////
  // for-loop with guard                       //
  ///////////////////////////////////////////////
  for {
    i <- 1 to 10
    if i % 2 == 0
  } {
    Console.print(s"$i, ")
  }
  ///////////////////////////////////////////////

  println()
  println()

  println("Count to 100 by 10 steps")
  println("<press enter>")
  Console.in.readLine()

  ///////////////////////////////////////////////
  // for-loop with custom step width           //
  ///////////////////////////////////////////////
  for {
    i <- 0 to 100 by 10
  } {
    Console.print(s"$i, ")
  }
  ///////////////////////////////////////////////

  println()
  println()

  println("Count while i < 5")
  println("<press enter>")
  Console.in.readLine()

  ///////////////////////////////////////////////
  // while-loop                                //
  ///////////////////////////////////////////////
  var i = 0
  while (i < 5) {
    print(s"$i, ")
    i += 1
  }
  ///////////////////////////////////////////////

  println()
  println()

  println("Bye Bye")
}
