package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

case class GameState(logic: GameLogic, history: List[(Gesture, Gesture)] = List.empty) {

  def update(a: Gesture, b: Gesture): GameState = {
    copy(history = history :+ (a -> b))
  }

  val lastOutcome: Option[Outcome] = history.lastOption.map {
    case (a, b) => logic(a, b)
  }

  val score: (Int, Int) = {

    val outcomes = history.map {
      case (a, b) => logic(a, b)
    }

    outcomes.count(_ == Victory) ->
      outcomes.count(_ == Defeat)
  }
}

