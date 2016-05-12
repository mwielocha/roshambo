package io.cyberdolphins.roshambo

import org.scalatest.{FlatSpec, MustMatchers}

import io.cyberdolphins.roshambo.views._
import scala.collection.mutable

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class ConsoleAppSpec extends FlatSpec with MustMatchers {

  /*

   Testing console ui means testing side-effects, best way to test side-effects is mutable state imho.

   */

  class MutableOutput extends Output {

    val screenBuffer = new mutable.ArrayBuffer[String]

    def write(s: String) = screenBuffer += s.stripMargin.trim
  }

  class IterableInput(scenario: String*) extends Input {

    val inputs = scenario.toIterator

    def read = if(inputs.hasNext) Some(inputs.next) else None
  }

  class Interaction(steps: String*) {

    implicit val out = new MutableOutput

    implicit val in = new IterableInput(steps: _*)

    val consoleApp: View = ConsoleApp()

    consoleApp()

    val visitedScreens = out.screenBuffer.toList
  }

  "ConsoleApp" should "display the welcome menu" in new Interaction() {

    visitedScreens mustBe List("""
      | 1. Rock Paper Scissors
      | 0. Exit
    """).map(_.stripMargin.trim)
  }

  it should "go from the welcome menu to game menu" in new Interaction("1") {

    visitedScreens mustBe List(
    """
      | 1. Rock Paper Scissors
      | 0. Exit
    """,
    """
      | 1. Player vs Player
      | 2. Player vs Computer
      | 3. Computer vs Computer
      | 0. Back
    """).map(_.stripMargin.trim)
  }

  it should "go from the welcome menu to game menu and back" in new Interaction("1", "0") {

    visitedScreens mustBe List(
    """
      | 1. Rock Paper Scissors
      | 0. Exit
    """,
    """
      | 1. Player vs Player
      | 2. Player vs Computer
      | 3. Computer vs Computer
      | 0. Back
    """,
    """
      | 1. Rock Paper Scissors
      | 0. Exit
    """).map(_.stripMargin.trim)
  }
}

