package io.cyberdolphins.roshambo.ai

import io.cyberdolphins.roshambo.game._ 

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait GameStrategy {

  type Move = (Gesture, Gesture)

  def apply(history: List[Move]): Option[Gesture]

}

