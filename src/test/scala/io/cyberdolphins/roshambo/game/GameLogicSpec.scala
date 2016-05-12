package io.cyberdolphins.roshambo.game

import org.scalatest.{FlatSpec, MustMatchers}

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameLogicSpec extends FlatSpec with MustMatchers {

  val logic: GameLogic = new GameLogic

  def givenGestures(a: Gesture, b: Gesture, outcome: Outcome) = {
    logic(a, b) mustBe outcome
  }

  "A game with no rules" should "always be a defeat" in {

    val gestures = List(Rock, Paper, Scissors)

    val outcomes = for {
      a <- gestures
      b <- gestures
    } yield logic(a, b)

    outcomes.distinct mustBe List(Defeat)
  }
}

