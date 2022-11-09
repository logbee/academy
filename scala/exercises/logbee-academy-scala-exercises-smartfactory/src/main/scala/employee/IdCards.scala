package employee
import employee.IdCard
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Path}
import scala.io.Source

object IdCards {
  def readIdCards(sourceFile: String): List[IdCard] = {
    // TODO: Read file from sourceFile "employeeNames.txt" and save it into String List
    //  remember that the ID of our employees is the line of their information
    ???
    /*
    val cards = List[IdCard]
    val source = Source.fromFile("data/employeeNames.txt")
    val lines = source.mkString
    val line = lines.split(",")
    */
  }

  def printCEOIdCards(destinationFile: String): Unit = {
    // TODO: We need the ID Card for our CEO and have to save it into a file named
    //  IdCEO.txt. Try to create a file and use only the information of our CEO
    //  Remember to use the template from file "templateIdCard.txt"
    ???
  }
}