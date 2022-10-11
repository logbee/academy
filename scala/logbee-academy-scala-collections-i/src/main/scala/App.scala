
@main
def main(): Unit = {
    // Save the secret identity of your favorite Heros in a Map
    // and link it with their superhero names
    val identity = Map(
        "Spiderman" -> "Peter Parker",
        "Ironman" -> "Tony Stark",
        "Hulk" -> "Bruce Banner"
    )

    // You forget the identity? Just search for them in your Map!
    val whoIsSpiderman = identity("Spiderman")
    val whoIsIronman = identity("Ironman")
    println(whoIsSpiderman)
    println(whoIsIronman)


    //Now you finally met Spiderman aka Peter Parker and told him that you now his secret
    //He asked you to remove his real name from your map
    val identityUpdated = identity.updated("Spiderman", " ")


    //Everyone knows who Ironman's real name is. You want to delete this Position
    val identityUpdatedUpdated: Map[String, String] = identityUpdated - "Ironman"


    //To get a better output we can define a methods who gives us the name and superpowers
    //First we have to create a map and link the superpowers to our heros
    val superpower = Map(
      "Spiderman" -> "Being a human Spider",
      "Ironman" -> "Being rich",
      "Hulk" -> "Being angry"
    )

    //Now we can define a method who gives us all information about our hero
    def superhero(name :String) : Unit = {
        println(s"Real name: ${identity(name)} / Superhero name: ${name} / Superpower: ${superpower(name)}")
    }

    superhero("Spiderman")
    superhero("Hulk")
}