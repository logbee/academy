import employee.IdCards
import factory.FireAlarmSystem.Detector
import factory.Factory
import inventory.{MillingMachine, Protocol}
import inventory.MillingMachine.Command
import inventory.MillingMachine.Cutter.{HighSpeedCutter, RoundCutter}
import inventory.MillingMachine.Power.{PowerOff, PowerOn}
import factory.parts.StealBlock
import inventory.Protocol.{EngineBlockProtocol, EngineCylinderProtocol}
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.matchers.should.Matchers.*
import sun.security.util.FilePaths

import scala.io.Source


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

        def checkProtocol(protocol: Protocol, resultList: List[Command]): Boolean = {

            protocol
              .toList
              .zip(resultList)
              .forall({ (protocolCommand, resultCommand) => protocolCommand == resultCommand })
        }


        "should have a functioning EngineBlockMillingMachine" in {

            val factory = Factory()
            val assemblyLine = factory.assemblyLine
            val stealBlock = StealBlock()

            val engineBlock = assemblyLine.engineCylinderMillingMachine.process(stealBlock)

            assert(checkProtocol(EngineBlockProtocol, assemblyLine.engineBlockMillingMachine.commands), "Not the correct order")

            assert(engineBlock != null)

        }

        "should have a functioning EngineCylinderMillingMachine" in {

            val factory = Factory()
            val assemblyLine = factory.assemblyLine
            val stealBlock = StealBlock()

            val engineCylinder = assemblyLine.engineCylinderMillingMachine.process(stealBlock)

            assert(checkProtocol(EngineCylinderProtocol, assemblyLine.engineCylinderMillingMachine.commands), "Not the correct order")

            assert(engineCylinder != null)
        }
    }

    "The IdCards" - {

        "should have all information in String List" in {
            val cards = IdCards.readIdCards("data/employeeNames.txt")
            cards should have size(23)
        }

        "should have the correct information of CEO in file <idCardCEO.txt> " in {
            IdCards.printCEOIdCards("data/IdCardCEO.txt")
            val source = Source.fromFile("data/IdCardCEO.txt")
            val actualContent = source.mkString
            source.close()
            val expectedContent =
                """
                  |ID: 1
                  |Name: Andrew , Reyes>
                  |Age: 35
                  |Position: Chief Executive Officer , 4
                  |""".stripMargin

            assert(actualContent == expectedContent, clue = "Your ID card do not match the template")

        }
    }
}
