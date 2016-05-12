package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object Variants {

  import GameLogicDsl._

  val rockPaperScissors = GameLogic { implicit builder =>

    Rock ~> Scissors ~> Paper ~> Rock

  }
}

