package io.cyberdolphins.roshambo

import io.cyberdolphins.roshambo.views._
import io.cyberdolphins.roshambo.game._
import Variants._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class ConsoleApp(implicit in: Input, out: Output) extends Menu(Exit) {

  val text = """
      | 1. Rock Paper Scissors
      | 0. Exit
    """

  def select = {
    case "1" => new Menu(this) {

      val text = """
          | 1. Player vs Player
          | 2. Player vs Computer
          | 3. Computer vs Computer
          | 0. Back
        """

      def select = {
        case "1" => PvPGameView(this, rockPaperScissors)
        case "2" => PvCGameView(this, rockPaperScissors)
        case "3" => CvCGameView(this, rockPaperScissors)
        case "0" => parent
      }
    }

    case "0" => Exit
  }
}

object ConsoleApp {

  def apply()(implicit in: Input, out: Output) = new ConsoleApp()

}

