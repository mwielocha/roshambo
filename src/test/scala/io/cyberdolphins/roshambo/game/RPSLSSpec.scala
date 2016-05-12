package io.cyberdolphins.roshambo.game

import org.scalatest.{FlatSpec, MustMatchers}

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class RPSLSSpec extends FlatSpec with MustMatchers {

  val rpsls: GameLogic = Variants.rockPaperScissorsLizardSpock

  "A game of rps" should "be a tie when Rock vs Rock" in {
    rpsls(Rock, Rock) mustBe Tie
  }

  it should "be a tie when Scissors vs Scissors" in {
    rpsls(Scissors, Scissors) mustBe Tie
  }

  it should "be a tie when Paper vs Paper" in {
    rpsls(Paper, Paper) mustBe Tie
  }

  it should "be a tie when Spock vs Spock" in {
    rpsls(Spock, Spock) mustBe Tie
  }

  it should "be a tie when Lizard vs Lizard" in {
    rpsls(Lizard, Lizard) mustBe Tie
  }

  // Victories

  it should "be a victory when Rock vs Scissors" in {
    rpsls(Rock, Scissors) mustBe Victory
  }

  it should "be a victory when Rock vs Lizard" in {
    rpsls(Rock, Lizard) mustBe Victory
  }

  it should "be a victory when Paper vs Rock" in {
    rpsls(Paper, Rock) mustBe Victory
  }

  it should "be a victory when Paper vs Spock" in {
    rpsls(Paper, Spock) mustBe Victory
  }

  it should "be a victory when Scissors vs Paper" in {
    rpsls(Scissors, Paper) mustBe Victory
  }

  it should "be a victory when Scissors vs Lizard" in {
    rpsls(Scissors, Lizard) mustBe Victory
  }

  it should "be a victory when Spock vs Rock" in {
    rpsls(Spock, Rock) mustBe Victory
  }

  it should "be a victory when Spock vs Scissors" in {
    rpsls(Spock, Scissors) mustBe Victory
  }

  it should "be a victory when Lizard vs Spock" in {
    rpsls(Lizard, Spock) mustBe Victory
  }

  it should "be a victory when Lizard vs Rock" in {
    rpsls(Lizard, Rock) mustBe Victory
  }

  // Defeats

  it should "be a defeat when Paper vs Scissors" in {
    rpsls(Paper, Scissors) mustBe Defeat
  }

  it should "be a defeat when Paper vs Lizard" in {
    rpsls(Paper, Lizard) mustBe Defeat
  }

  it should "be a defeat when Rock vs Paper" in {
    rpsls(Rock, Paper) mustBe Defeat
  }

  it should "be a defeat when Rock vs Spock" in {
    rpsls(Rock, Spock) mustBe Defeat
  }

  it should "be a defeat when Scissors vs Rock" in {
    rpsls(Scissors, Rock) mustBe Defeat
  }

  it should "be a defeat when Scissors vs Spock" in {
    rpsls(Scissors, Spock) mustBe Defeat
  }

  it should "be a defeat when Lizard vs Rock" in {
    rpsls(Lizard, Rock) mustBe Defeat
  }

  it should "be a defeat when Lizard vs Scissors" in {
    rpsls(Lizard, Scissors) mustBe Defeat
  }

  it should "be a defeat when Spock vs Paper" in {
    rpsls(Spock, Paper) mustBe Defeat
  }

  it should "be a defeat when Spock vs Lizard" in {
    rpsls(Spock, Lizard) mustBe Defeat
  }
}

