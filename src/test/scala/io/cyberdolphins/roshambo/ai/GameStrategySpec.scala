package io.cyberdolphins.roshambo.ai

import io.cyberdolphins.roshambo.game._

import org.scalatest.{FlatSpec, MustMatchers}

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameStrategySpec extends FlatSpec with MustMatchers {

  "Frequency based game strategy" should "determine next move base of historical frequency" in {

    val strategy: GameStrategy = MostFrequentMoveStrategy(Variants.rockPaperScissors)

    strategy(
      List(
        (Rock -> Paper),
        (Rock -> Scissors),
        (Scissors -> Rock)
      )
    ) mustBe Some(Paper)
  }

  "Pattern recognition strategy" should "determine next move base of historical patterns" in {

    val strategy: GameStrategy = PatternRecognitionStrategy(Variants.rockPaperScissors, 3)

    strategy(
      List(
        (Rock -> Paper),
        (Rock -> Scissors),
        (Scissors -> Rock),
        (Paper -> Paper),
        (Rock -> Scissors),
        (Paper -> Rock),
        (Rock -> Paper),
        (Rock -> Scissors),
        (Scissors -> Rock)
      )
    ) mustBe Some(Scissors)
  }
}
