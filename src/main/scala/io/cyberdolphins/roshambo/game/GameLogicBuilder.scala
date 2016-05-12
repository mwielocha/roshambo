package io.cyberdolphins.roshambo.game

import scala.collection.mutable

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameLogicBuilder {

  type Rule = (Gesture, Gesture)

  /*
   This mutable state is fully isolated.
   */

  val rules = new mutable.ArrayBuffer[Rule]()
}
