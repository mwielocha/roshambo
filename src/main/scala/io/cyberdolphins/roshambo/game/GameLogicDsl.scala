package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object GameLogicDsl {

  implicit class GameLogicBuilderBuilderBlock(val a: Gesture) {

    def beats(b: Gesture)(implicit builder: GameLogicBuilder): Gesture = {
      builder.rules += a -> b; b
    }

    def ~>(b: Gesture)(implicit builder: GameLogicBuilder): Gesture = beats(b)
  }
}

