package factory

import factory.AssemblyLine.EngineBlockMillingMachine
import factory.AssemblyLine.EngineCylinderMillingMachine
import inventory.{MillingMachine, Protocol, Station}
import inventory.MillingMachine.Command
import inventory.MillingMachine.Command.SetPower
import inventory.MillingMachine.Cutter.HighSpeedCutter
import inventory.MillingMachine.Power.{PowerOff, PowerOn}
import factory.parts.{EngineBlock, EngineCylinder, Material, StealBlock}

package parts {

  trait Material

  case class StealBlock() extends Material

  case class EngineBlock() extends Material

  case class EngineCylinder() extends Material

  case class Engine(block: EngineBlock, cylinders: List[EngineCylinder])

}

class AssemblyLine {
  val engineBlockMillingMachine: EngineBlockMillingMachine = EngineBlockMillingMachine(Protocol.EngineBlockProtocol)
  val engineCylinderMillingMachine: EngineCylinderMillingMachine = EngineCylinderMillingMachine(Protocol.EngineBlockProtocol) // TODO: Fix protocol
}

object AssemblyLine {

  class EngineBlockMillingMachine(protocol: Protocol) extends MillingMachine[EngineBlock](protocol) with Station[StealBlock, EngineBlock] {
    override def process(in: StealBlock): EngineBlock = {
      // TODO follow all rules and try to complete the Milling Process for our EngineBlock
      setCutter(HighSpeedCutter)
      enableCooling()
      setPower(PowerOn)
      val result = milling()
      setPower(PowerOff)
      disableCooling()

      result
    }
  }

  class EngineCylinderMillingMachine(protocol: Protocol) extends MillingMachine[EngineCylinder](protocol) with Station[StealBlock, EngineCylinder] {
    override def process(in: StealBlock): EngineCylinder = {
      // TODO define the Milling Process for our EngineCylinder
      // setCutter(HighSpeedCutter)
      enableCooling()
      setPower(PowerOn)
      val result = milling()
      setPower(PowerOff)
      //disableCooling()

      result
    }
  }

}

