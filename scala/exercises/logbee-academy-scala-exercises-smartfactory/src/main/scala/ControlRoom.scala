import factory.FireAlarmSystem.Detector
import factory.Factory
import inventory.MillingMachine
import inventory.MillingMachine.Command
import inventory.MillingMachine.Cutters.{HighSpeedCutter, LowSpeedCutter, RoundCutter}
import inventory.MillingMachine.Power.{PowerOff, PowerOn}
import factory.parts.StealBlock
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.*


class ControlRoom extends AnyFreeSpec with Matchers {

    "The FireAlarmSystem" - {

        "should have enough water pressure when all pumps are running" in {

            val factory = Factory()
            factory.fireAlarmSystem.enableAllPumps()

            assert(factory.fireAlarmSystem.waterPressure() > 15.0, "Expected a water pressure of at least 15 bar!")
        }

        "should pass the detector test run" in {

            val factory = Factory()

            val testFunction = { (detector: Detector) => detector.health > 0.5 }

            assert(factory.fireAlarmSystem.detectorTest(testFunction) == 6, "Expected that all Detectors pass the test!")
        }
    }

    "The AssemblyLine" - {

        "should have a functioning EngineBlockMillingMachine" in {

            val factory = Factory()
            val assemblyLine = factory.assemblyLine
            val stealBlock = StealBlock()

            val engineBlock = assemblyLine.engineBlockMillingMachine.process(stealBlock)

            assert(assemblyLine.engineBlockMillingMachine.commands(0) == MillingMachine.Command.SetCutter(HighSpeedCutter), "command [1] should be SetCutter")
            assert(assemblyLine.engineBlockMillingMachine.commands(1) == MillingMachine.Command.EnableCooling , "command [2] should be EnableCooling")
            assert(assemblyLine.engineBlockMillingMachine.commands(2) == MillingMachine.Command.SetPower(PowerOn), "command [3] should be SetPower")
            assert(assemblyLine.engineBlockMillingMachine.commands(3) == MillingMachine.Command.Milling, "command [4] should be Milling")
            assert(assemblyLine.engineBlockMillingMachine.commands(4) == MillingMachine.Command.SetPower(PowerOff), "command [5] should be SetPower")
            assert(assemblyLine.engineBlockMillingMachine.commands(5) == MillingMachine.Command.DisableCooling, "command [6] should be DisableCooling")
            assert(assemblyLine.engineBlockMillingMachine.commands(6) == MillingMachine.Command.SetCutter(LowSpeedCutter), "command [7] should be SetCutter")
            assert(assemblyLine.engineBlockMillingMachine.commands(7) == MillingMachine.Command.EnableCooling, "command [8] should be EnableCooling")
            assert(assemblyLine.engineBlockMillingMachine.commands(8) == MillingMachine.Command.SetPower(PowerOn), "command [9] should be SetPower")
            assert(assemblyLine.engineBlockMillingMachine.commands(9) == MillingMachine.Command.Milling, "command [10] should be Milling")
            assert(assemblyLine.engineBlockMillingMachine.commands(10) == MillingMachine.Command.SetPower(PowerOff) , "command [11] should be SetPower")
            assert(assemblyLine.engineBlockMillingMachine.commands(11) == MillingMachine.Command.DisableCooling, "command [12] should be DisableCooling")

            assert(engineBlock != null)
        }

        "should have a functioning EngineCylinderMillingMachine" in {

            val factory = Factory()
            val assemblyLine = factory.assemblyLine
            val stealBlock = StealBlock()

            val engineCylinder = assemblyLine.engineCylinderMillingMachine.process(stealBlock)

            assert(assemblyLine.engineCylinderMillingMachine.commands(0) == MillingMachine.Command.SetCutter(LowSpeedCutter), "command [1] should be SetCutter")
            assert(assemblyLine.engineCylinderMillingMachine.commands(1) == MillingMachine.Command.EnableCooling, "command [2] should be EnableCooling")
            assert(assemblyLine.engineCylinderMillingMachine.commands(2) == MillingMachine.Command.SetPower(PowerOn), "command [3] should be SetPower")
            assert(assemblyLine.engineCylinderMillingMachine.commands(3) == MillingMachine.Command.Milling, "command [4] should be Milling")
            assert(assemblyLine.engineCylinderMillingMachine.commands(4) == MillingMachine.Command.SetPower(PowerOff), "command [5] should be SetPower")
            assert(assemblyLine.engineCylinderMillingMachine.commands(5) == MillingMachine.Command.DisableCooling, "command [6] should be DisableCooling")
            assert(assemblyLine.engineCylinderMillingMachine.commands(6) == MillingMachine.Command.SetCutter(RoundCutter), "command [7] should be SetCutter")
            assert(assemblyLine.engineCylinderMillingMachine.commands(7) == MillingMachine.Command.EnableCooling, "command [8] should be EnableCooling")
            assert(assemblyLine.engineCylinderMillingMachine.commands(8) == MillingMachine.Command.SetPower(PowerOn), "command [9] should be SetPower")
            assert(assemblyLine.engineCylinderMillingMachine.commands(9) == MillingMachine.Command.Milling, "command [10] should be Milling")
            assert(assemblyLine.engineCylinderMillingMachine.commands(10) == MillingMachine.Command.SetPower(PowerOff), "command [11] should be SetPower")
            assert(assemblyLine.engineCylinderMillingMachine.commands(11) == MillingMachine.Command.DisableCooling, "command [12] should be DisableCooling")

            assert(engineCylinder != null)
        }
    }
}
