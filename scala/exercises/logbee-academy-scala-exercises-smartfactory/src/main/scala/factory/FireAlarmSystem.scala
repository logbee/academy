package factory

import factory.FireAlarmSystem.{Detector, WaterPump}

class FireAlarmSystem() {

  val pumps: List[WaterPump] = List(
    WaterPump("Pump-A"),
    WaterPump("Pump-B"),
    WaterPump("Pump-C"),
  )

  val detectors: List[Detector] = List(
    Detector("D-02A", 0.8),
    Detector("D-33C", 0.55),
    Detector("D-78A", 0.75),
    Detector("D-09D", 0.9),
    Detector("D-12T", 0.66),
    Detector("D-88X", 1.0),
  )

  def enableAllPumps(): Unit = {
    // TODO: Fix the main switch for WaterPumps of the FireAlarmSystem.
    // This function should call the enable function of each pump.
    ???
  }

  def detectorTest(testFunction: Detector => Boolean): Int = {
    // TODO: Fix the detector test so we are sure that the FireAlarmSystem will trigger in case of fire.
    // Apply the testFunction to all Detectors and return the number of detectors which pass the test (the testFunction returns true).
    ???
  }

  def waterPressure(): Double = {
    pumps.map(_.pressure()).sum
  }
}

object FireAlarmSystem {

  case class WaterPump(name: String) {

    private var isRunning = false

    def enable(): Unit = {
      isRunning = true
    }

    def disable(): Unit = {
      isRunning = false
    }

    def pressure(): Double = {
      if (isRunning) {
        5.4
      }
      else {
        0
      }
    }
  }

  case class Detector(name: String, health: Double)
}
