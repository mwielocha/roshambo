package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameLogic(private val rules: Set[(Gesture, Gesture)] = Set.empty) {

  def apply(a: Gesture, b: Gesture): Outcome =  a match {
    case `b` => Tie
    case x if rules(x -> b) => Victory
    case _ => Defeat
  }
}

