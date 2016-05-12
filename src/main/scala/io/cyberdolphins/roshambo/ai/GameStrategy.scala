package io.cyberdolphins.roshambo.ai

import io.cyberdolphins.roshambo.game._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait GameStrategy {

  val logic: GameLogic

  type Move = (Gesture, Gesture)

  def apply(history: List[Move]): Option[Gesture]

}

case class MostFrequentMoveStrategy(val logic: GameLogic) extends GameStrategy {

  def apply(history: List[Move]): Option[Gesture] = {
    history.groupBy {
      case (a, b) => a
    }.toList.sortBy(_._2.size)
      .reverse.headOption.map(_._1)
      .flatMap(logic.adversaryOf)
  }
}

