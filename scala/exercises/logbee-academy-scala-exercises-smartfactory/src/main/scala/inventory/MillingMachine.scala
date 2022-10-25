package inventory

import inventory.MillingMachine.Command


abstract class MillingMachine {

  var commands: List[Command] = List.empty

  def setCutter(cutter: MillingMachine.Cutters): Unit = {
    commands = commands :+ Command.SetCutter(cutter)
  }

  def setPower(power: MillingMachine.Power): Unit = {
    commands = commands :+ Command.SetPower(power)
  }

  def enableCooling(): Unit = {
    commands = commands :+ Command.EnableCooling
  }

  def disableCooling(): Unit = {
    commands = commands :+ Command.DisableCooling
  }

  def milling(): Unit = {
    commands = commands :+ Command.Milling
  }
}

object MillingMachine {

  enum Cutters {
    case HighSpeedCutter
    case LowSpeedCutter
    case RoundCutter
  }

  enum Power {
    case PowerOn
    case PowerOff
  }

  enum Command {
    case EnableCooling
    case DisableCooling
    case Milling
    case SetCutter(val cutter: Cutters)
    case SetPower(val power: Power)
  }
}
