package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._
import scala.util.Random
import scala.collection.breakOut

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait Player {
  def move: Option[Gesture]
}

class Human(logic: GameLogic)(implicit val in: Input) extends Player {

  val gestures: Map[String, Gesture] = {
    logic.availableGestures.zipWithIndex.map {
      case (g, i) => s"${i + 1}" -> g
    } (breakOut)
  }

  def move = in.read.flatMap(gestures.get)
}

class Computer(logic: GameLogic) extends Player {

  def move = Random.shuffle(logic.availableGestures).headOption
}
