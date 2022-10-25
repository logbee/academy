package inventory

trait Station[In, Out] {
  def process(in: In): Out
}
