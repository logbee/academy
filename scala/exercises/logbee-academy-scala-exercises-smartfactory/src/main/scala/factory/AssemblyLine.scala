package factory

import factory.AssemblyLine.EngineBlockMillingMachine
import factory.AssemblyLine.EngineCylinderMillingMachine
import factory.AssemblyLine.MillingMachine.Command
import factory.AssemblyLine.MillingMachine.Command.{SetPower}
import factory.AssemblyLine.MillingMachine.Cutters.{HighSpeedCutter, LowSpeedCutter}
import factory.AssemblyLine.MillingMachine.Power.{PowerOff, PowerOn}
import factory.parts.{EngineBlock, EngineCylinder, StealBlock}

package parts {
  case class StealBlock()
  case class EngineBlock()
  case class EngineCylinder()
  case class Engine(block: EngineBlock, cylinders: List[EngineCylinder])

}

class AssemblyLine {
  // oh no some Assembly Line stations are damaged
  // make sure to fix all for start producing
  val engineBlockMillingMachine: EngineBlockMillingMachine = EngineBlockMillingMachine()
  val engineCylinderMillingMachine: EngineCylinderMillingMachine = EngineCylinderMillingMachine()

}

object AssemblyLine {

  trait Station[In, Out] {
    def process(in: In): Out
  }

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
  class EngineBlockMillingMachine() extends MillingMachine with Station[StealBlock, EngineBlock] {
    override def process(in: StealBlock): EngineBlock = {
      // TODO follow all rules and try to complete the Milling Process for our EngineBlock
      // -> first set Cutter, then enable Cooling and start Machine
      // -> Machine have to do the work (Milling) and set to power off (don´t miss to disable cooling)
      // -> We first need to Cut with the <HighSpeedCutter> and then with the <LowerSpeedCutter>
      setCutter(HighSpeedCutter)
      enableCooling()
      setPower(PowerOn)
      milling()
      setPower(PowerOff)
      disableCooling()
      setCutter(LowSpeedCutter)
      enableCooling()
      setPower(PowerOn)
      milling()
      setPower(PowerOff)
      disableCooling()

      val engineBlock = EngineBlock()

      engineBlock
    }
  }


  // TODO we also need to define a new class <EngineCylinderMillingMachine>
  //  and define the Milling Process for our EngineCylinder
  // Here we can put a StealBlock in and get EngineCylinder back
  // The working steps are Set LowSpeedCutter and then Set RoundCutter
  // Make sure to follow the same rules as in your task before
  class EngineCylinderMillingMachine() extends MillingMachine with Station[StealBlock, EngineCylinder] {
    override def process(in: StealBlock): EngineCylinder = {

    val engineCylinder = EngineCylinder()

    engineCylinder
    }
  }

  class Printing3D {

  }

  class Assembly {

  }
  }

