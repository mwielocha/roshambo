package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameLogic(private val rules: Set[(Gesture, Gesture)] = Set.empty) {

  def availableGestures = rules.map(_._1)
    .toList
    .sortBy(_.toString)

  def adversaryOf(g: Gesture): Option[Gesture] = {
    availableGestures.find(apply(_, g) == Victory)
  }

  def apply(a: Gesture, b: Gesture): Outcome =  a match {
    case `b` => Tie
    case x if rules(x -> b) => Victory
    case _ => Defeat
  }
}

object GameLogic {

  def apply(builderScope: GameLogicBuilder => Unit): GameLogic = {

    val builder = new GameLogicBuilder()

    builderScope(builder)

    new GameLogic(builder.rules.toSet)
  }
}

