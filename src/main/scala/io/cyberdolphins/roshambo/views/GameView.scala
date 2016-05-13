package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object PvPGameView {

  def apply(parent: View, logic: GameLogic)(implicit in: Input, out: Output) = {
    new GameView(parent, logic, new Human(logic), new Human(logic), GameState(logic))
  }
}

object PvCGameView {

  def apply(parent: View, logic: GameLogic)(implicit in: Input, out: Output) = {
    new GameView(parent, logic, new Human(logic), new Computer(logic), GameState(logic))
  }
}

object CvCGameView {

  def apply(parent: View, logic: GameLogic)(implicit in: Input, out: Output) = {
    new GameView(parent, logic, new Computer(logic), new Computer(logic), GameState(logic))
  }
}

class GameView(
  parent: View,
  val logic: GameLogic,
  val player1: Player,
  val player2: Player,
  val state: GameState
)(implicit override val in: Input, override val out: Output) extends AbstractView(parent) {

  def updateState(newState: GameState): GameView = {
    new GameView(
      parent,
      logic,
      player1,
      player2,
      newState
    )
  }

  val gestures = {
    logic.availableGestures.toList
      .sortBy(_.toString)
      .zipWithIndex.map {
        case (g, i) => s"${i + 1}" -> g
      }
  }

  val text = {
    gestures.map {
      case (i, g) => s"""
       | $i. $g"""
    }.mkString("") + "\n"
  }

  type History = List[(Gesture, Gesture)]

  def move(p: Player, history: History): Gesture = {

    p.move(history) match {
      case Some(g) => g
      case None =>

        out.write("""
         | Sorry, I didn't get that...
        """)

        move(p, history)
    }
  }

  override def next = {

    val a = move(player1, state.history.map(_.swap))
    val b = move(player2, state.history)

    val newState: GameState = state.update(a, b)

    val verdict = newState.lastOutcome match {
      case Some(Victory) => "Player1 wins!"
      case Some(Defeat) => "Player2 wins!"
      case _ => "We have a tie"
    }

    out.write(s"""
     | $a vs $b
     | $verdict""")

    val score = newState.score match {

      case _ if state.isEmpty => ()

      case (x, y) if x == y => out.write(s"""
       | A tie so far with $x : $y""")

      case (x, y) if x > y => out.write(s"""
       | Player1 is in the lead with $x : $y""")

      case (x, y) if x < y => out.write(s"""
       | Player2 is in the lead with $x : $y""")
    }

    out.write("""
     | Play again?
     |
     | 1. Yes
     | 2. No
    """)

    playAgain(newState)
  }

  def playAgain(newState: GameState): View = {

    read() match {
      case Some("1") => updateState(newState)
      case Some("2") => parent
      case _ =>

        out.write("""
         | Not sure what you mean :(
        """)

        playAgain(newState)
    }
  }
}
