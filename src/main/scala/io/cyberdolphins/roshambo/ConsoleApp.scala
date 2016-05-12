package io.cyberdolphins.roshambo

import io.cyberdolphins.roshambo.views._
import io.cyberdolphins.roshambo.game.Variants._

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

        case "1" =>

          new GameView(
            this, rockPaperScissors,
            new Human(rockPaperScissors),
            new Human(rockPaperScissors)
          )

        case "2" =>

          new GameView(
            this, rockPaperScissors,
            new Human(rockPaperScissors),
            new Computer(rockPaperScissors)
          )

        case "3" =>

          new GameView(
            this, rockPaperScissors,
            new Computer(rockPaperScissors),
            new Computer(rockPaperScissors)
          )

        case "0" => parent
      }
    }

    case "0" => Exit
  }
}

object ConsoleApp {

  def apply()(implicit in: Input, out: Output) = new ConsoleApp()

}

