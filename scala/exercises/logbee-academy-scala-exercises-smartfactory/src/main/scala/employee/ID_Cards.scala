package employee

import sun.security.util.FilePaths

abstract class ID_Card(id: Integer) {
  val name: String
  val lastname: String
  val position: String
  val accessRight: Integer
  val age: Integer
}

// TODO implement method to create id Cards
//  use file read to get information out of employeeNames.txt