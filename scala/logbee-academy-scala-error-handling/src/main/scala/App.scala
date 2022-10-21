
@main
def main(): Unit = {
  println(division(5,0.00));

  // Sometimes your programm does not work right and you get only error messages
  // now you can find your mistake. But you can handle those errors directly in your code
  // for that you can use Exceptions.

  // Example one
  def division(x: Int, y: Double) : Double = {
    x/y
  }
  // the programm does not tell you that you will divide by zero
  // for that we can define a new exception
  def division_withException(x: Int, y: Double): Double = {
    try
    x / y
  }


  // String to integer aufrufen




  }
