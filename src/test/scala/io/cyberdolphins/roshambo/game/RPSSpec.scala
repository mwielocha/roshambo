package io.cyberdolphins.roshambo.game

import org.scalatest.{FlatSpec, MustMatchers}

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class RPSSpec extends FlatSpec with MustMatchers {

  val rps: GameLogic = new GameLogic

  "A game of rps" should "be a tie when Rock vs Rock" in {
    rps(Rock, Rock) mustBe Tie
  }

  it should "be a tie when Scissors vs Scissors" in {
    rps(Scissors, Scissors) mustBe Tie
  }

  it should "be a tie when Paper vs Paper" in {
    rps(Paper, Paper) mustBe Tie
  }

  it should "be a victory when Rock vs Scissors" in {
    rps(Rock, Scissors) mustBe Victory
  }

  it should "be a victory when Paper vs Rock" in {
    rps(Paper, Rock) mustBe Victory
  }

  it should "be a victory when Scissors vs Paper" in {
    rps(Scissors, Paper) mustBe Victory
  }

  it should "be a defeat when Paper vs Scissors" in {
    rps(Paper, Scissors) mustBe Victory
  }

  it should "be a defeat when Rock vs Paper" in {
    rps(Rock, Paper) mustBe Victory
  }

  it should "be a defeat when Scissors vs Rock" in {
    rps(Scissors, Rock) mustBe Victory
  }
}

