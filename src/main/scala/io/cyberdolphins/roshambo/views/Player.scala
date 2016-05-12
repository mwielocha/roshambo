package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._
import io.cyberdolphins.roshambo.ai._
import scala.util.Random
import scala.collection.breakOut

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait Player {
  def move(history: List[(Gesture, Gesture)]): Option[Gesture]
}

class Human(logic: GameLogic)(implicit val in: Input) extends Player {

  val gestures: Map[String, Gesture] = {
    logic.availableGestures.zipWithIndex.map {
      case (g, i) => s"${i + 1}" -> g
    } (breakOut)
  }

  def move(history: List[(Gesture, Gesture)]) = in.read.flatMap(gestures.get)
}

class Computer(logic: GameLogic) extends Player {

  val strategies = GameStrategyChain(
    PatternRecognitionStrategy(logic, logic.availableGestures.size),
    MostFrequentMoveStrategy(logic),
    RandomStrategy(logic)
  )

  def move(history: List[(Gesture, Gesture)]) = strategies(history)
}
