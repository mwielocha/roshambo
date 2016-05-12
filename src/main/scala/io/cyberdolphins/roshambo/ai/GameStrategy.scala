package io.cyberdolphins.roshambo.ai

import scala.util.Random
import io.cyberdolphins.roshambo.game._


/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait GameStrategy {

  type Move = (Gesture, Gesture)

  def apply(history: List[Move]): Option[Gesture]

}

case class RandomStrategy(val logic: GameLogic) extends GameStrategy {

  def apply(history: List[Move]): Option[Gesture] = {
    Random.shuffle(logic.availableGestures).headOption
  }
}

case class MostFrequentMoveStrategy(val logic: GameLogic) extends GameStrategy {

  def apply(history: List[Move]): Option[Gesture] = {
    history.groupBy {
      case (a, b) => a
    }.toList
      .filterNot(_._2.size < 2)
      .sortBy(_._2.size)
      .reverse.headOption.map(_._1)
      .flatMap(logic.adversaryOf)
  }
}

case class PatternRecognitionStrategy(val logic: GameLogic, bufferSize: Int = 3) extends GameStrategy {

  def apply(history: List[Move]): Option[Gesture] = {

    val enemyGestures = history.map(_._1)

    val lastXGestures = enemyGestures
      .reverse
      .take(bufferSize)
      .reverse

    val meanigfulGestures = enemyGestures
      .reverse
      .drop(bufferSize)
      .reverse

    meanigfulGestures.sliding(bufferSize + 1)
      .find(_.take(bufferSize) == lastXGestures)
      .flatMap(_.lastOption.flatMap(logic.adversaryOf))
  }
}

case class GameStrategyChain(strategies: GameStrategy*) extends GameStrategy {

  def apply(history: List[Move]): Option[Gesture] = {
    strategies.flatMap(_.apply(history)).headOption
  }
}

