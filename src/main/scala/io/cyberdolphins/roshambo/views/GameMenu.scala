package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._

/**
 * Created by Mikolaj Wielocha on 13/05/16
 */

class GameMenu(parent: View, logic: GameLogic)(implicit in: Input, out: Output) extends Menu(parent) {

  val text = """
          | 1. Player vs Player
          | 2. Player vs Computer
          | 3. Computer vs Computer
          | 0. Back
        """

  def select = {
    case "1" => PvPGameView(this, logic)
    case "2" => PvCGameView(this, logic)
    case "3" => CvCGameView(this, logic)
    case "0" => parent
  }
}
