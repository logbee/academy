import factory.FireAlarmSystem.Detector
import factory.Factory

import org.scalatest.freespec.AnyFreeSpec

class ControlRoom extends AnyFreeSpec {

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
}
