package inventory

import factory.parts.{EngineBlock, EngineCylinder, Material, StealBlock}
import inventory.MillingMachine.{Command, Cutter}
import inventory.MillingMachine.Command.*
import inventory.MillingMachine.Cutter.{HighSpeedCutter, RoundCutter}
import inventory.MillingMachine.Power.{PowerOff, PowerOn}
import inventory.Protocol

import scala.language.postfixOps


abstract class MillingMachine[Out <: Material](private val protocol: Protocol) {

  var commands: List[Command] = List.empty
  var currentCutter: Option[Cutter[Out]] = None

  def setCutter(cutter: MillingMachine.Cutter[Out]): Unit = {
    commands = commands :+ Command.SetCutter(cutter)
    currentCutter = Some(cutter)
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

  def milling(): Out = {
    commands = commands :+ Command.Milling
    val result = currentCutter match {
      case Some(cutter) => cutter(StealBlock()) // TODO: Maybe remove input material?
      case None => ??? // TODO: Handle when no cutter is mounted!
    }
    result
  }
}


object MillingMachine {

  sealed trait Cutter[Out <: Material] {
    def apply(material: StealBlock): Out
  }

  object Cutter {
    case object HighSpeedCutter extends Cutter[EngineBlock] {
      override def apply(material: StealBlock): EngineBlock = {
        EngineBlock()
      }
    }

    case object RoundCutter extends Cutter[EngineCylinder] {
      override def apply(material: StealBlock): EngineCylinder = {
        EngineCylinder()
      }
    }
  }

  enum Power {
    case PowerOn
    case PowerOff
  }

  enum Command {
    case EnableCooling
    case DisableCooling
    case Milling
    case SetCutter[Out <: Material](val cutter: Cutter[Out])
    case SetPower(val power: Power)
  }

}

type Protocol = Seq[Command]

object Protocol {

    val EngineBlockProtocol: Seq[Command] = Seq(
      SetCutter(HighSpeedCutter),
      EnableCooling,
      SetPower(PowerOn),
      Milling,
      SetPower(PowerOff),
      DisableCooling
    )

    val EngineCylinderProtocol: Seq[Command] = Seq(
      SetCutter(RoundCutter),
      EnableCooling,
      SetPower(PowerOn),
      Milling,
      SetPower(PowerOff),
      DisableCooling
  )
}