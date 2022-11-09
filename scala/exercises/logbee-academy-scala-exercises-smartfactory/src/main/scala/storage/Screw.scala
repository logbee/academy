package storage

abstract class Screw {
  var quantity: Integer = 0
  var minQuantity: Integer = 0
  var maxQuanitiy: Integer = 0
}

case class M3() extends Screw {
  quantity = 700
  maxQuanitiy = 3000
  minQuantity = 300
}

case class M4() extends Screw{
  quantity = 300
  maxQuanitiy = 4000
  minQuantity = 600
}

case class M6() extends Screw{
  quantity = 900
}