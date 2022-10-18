// To remember all 9 (or 8 without Pluto) planets we want to
// define those to know their names and their distance from sun
class planet(var name: String, var distance_in_million_miles: Int) {
  val planet_name = this.name
  val distance = this.distance_in_million_miles

  def print_planet(): Unit = {
    println(s"Planet: ${planet_name} is ${distance} million miles away from sun")
  }
}

  //if we want to define all 9 planets we can also use Enums
enum Planet(distance: Integer) {
  case Mercury extends Planet(35)
  case Venus extends Planet(67)
  case Earth extends Planet(94)
  // ...

  //Also here an small method to give us our information
  def print_planet(): Unit = {
    println(s"Planet: ${this.toString} is ${this.distance} million miles away from sun")
  }
}

@main
def main(): Unit = {
  // use our class to define new planets
  val mercury = new planet("Mercury",35)
  val venus = new planet("Venus",67)
  val earth = new planet("Earth",94)
  //...

  //  we have defined our planets and now we can use our methods
  mercury.print_planet()
  venus.print_planet()
  earth.print_planet()

  // its easier to use Enums when you have to define many similar objects
  // now we defined our Enum and only have to import our enum (.* means all elements)
  import Planet.*

  // and we can use each planet and simply use our defined methods
  Earth.print_planet()
  Venus.print_planet()
  Mercury.print_planet()
}