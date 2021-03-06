package io.cyberdolphins.roshambo.game

import org.scalatest.{FlatSpec, MustMatchers}

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameLogicSpec extends FlatSpec with MustMatchers {

  "A game with no rules" should "never be a victory" in {

    val logic: GameLogic = new GameLogic

    val gestures = List(Rock, Paper, Scissors)

    val outcomes = for {
      a <- gestures
      b <- gestures
    } yield logic(a, b)

    outcomes must contain only(Tie, Defeat)
  }

  "A game with a single rule" should "be a victory only for one combination of gestures" in {

    import GameLogicDsl._

    val logic: GameLogic = GameLogic { implicit b =>
      Rock ~> Paper
    }

    val gestures = List(Rock, Paper, Scissors)

    val outcomes = for {
      a <- gestures
      b <- gestures
    } yield logic(a, b)

    outcomes.count(_ == Victory) mustBe 1
  }
}

