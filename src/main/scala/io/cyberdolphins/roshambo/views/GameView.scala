package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameView(
  parent: View,
  val logic: GameLogic,
  val player1: Player,
  val player2: Player,
  val state: GameState
)(implicit override val in: Input, override val out: Output) extends AbstractView(parent) {

  def updateState(a: Gesture, b: Gesture): GameView = {
    new GameView(
      parent,
      logic,
      player1,
      player2,
      state.update(a, b))
  }

  val gestures = {
    logic.availableGestures.zipWithIndex.map {
      case (g, i) => s"${i + 1}" -> g
    }
  }

  val text = {
    gestures.map {
      case (i, g) => s"""
       | $i. $g"""
    }.mkString("")
  }

  type History =  List[(Gesture, Gesture)]

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

    val verdict = logic(a, b) match {
      case Victory => "Player1 wins!"
      case Defeat => "Player2 wins!"
      case Tie => "We have a tie"
    }

    out.write(s"""
     | $a vs $b
     | $verdict""")

    out.write("""
     | Play again?
     |
     | 1. Yes
     | 2. No
    """)

    playAgain(a, b)
  }

  def playAgain(a: Gesture, b: Gesture): View = {

    read() match {
      case Some("1") => this.updateState(a, b)
      case Some("2") => parent
      case _ =>

        out.write("""
         | Not sure what you mean :(
        """)

        playAgain(a, b)
    }
  }
}
