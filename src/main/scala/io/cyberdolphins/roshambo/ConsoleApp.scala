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
      | 2. Rock Paper Scissors Lizard Spock
      | 0. Exit
    """

  def select = {
    case "1" => new GameMenu(this, rockPaperScissors)
    case "2" => new GameMenu(this, rockPaperScissorsLizardSpock)
    case "0" => Exit
  }
}

object ConsoleApp {

  def apply()(implicit in: Input, out: Output) = new ConsoleApp()

}

