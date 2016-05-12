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

    val visitedScreens = new mutable.ArrayBuffer[String]

    def write(s: String) = visitedScreens += s
  }

  class IterableInput(scenario: String*) extends Input {

    val inputs = scenario.toIterator

    def read = if(inputs.hasNext) Some(inputs.next) else None
  }

  val consoleApp: View = ???

  "ConsoleApp" should "display a welcome menu" in {

    implicit val out = new MutableOutput

    implicit val in = new IterableInput()

    consoleApp()

    out.visitedScreens mustBe List("""
      | 1. Rock Paper Scissors
      | 0. Exit
    """.stripMargin)
  }
}

