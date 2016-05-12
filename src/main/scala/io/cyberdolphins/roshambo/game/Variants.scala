package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object Variants {

  val rockPaperScissors = new GameLogic(Set(
    (Rock -> Scissors),
    (Scissors -> Paper),
    (Paper -> Rock)
  ))
}

