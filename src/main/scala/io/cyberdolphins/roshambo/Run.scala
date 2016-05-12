package io.cyberdolphins.roshambo

import io.cyberdolphins.roshambo.views._
import scala.io.StdIn._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object Run extends App {

  implicit val in = new Input {
    def read = Option(readLine())
  }

  implicit val out = new Output {
    def write(s: String) = println(s.stripMargin)
  }

  val consoleApp = ConsoleApp()

  consoleApp()
}

