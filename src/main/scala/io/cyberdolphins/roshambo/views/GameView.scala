package io.cyberdolphins.roshambo.views

import io.cyberdolphins.roshambo.game._

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

class GameView(
  parent: View,
  val logic: GameLogic,
  val player1: Player,
  val player2: Player
)(implicit override val in: Input, override val out: Output) extends AbstractView(parent) {

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

  def move(p: Player): Gesture = {
    p.move match {
      case Some(g) => g
      case None =>

        out.write("""
         | Sorry, I didn't get that...
        """)

        move(p)
    }
  }

  override def next = {

    val a = move(player1)
    val b = move(player2)

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

    playAgain
  }

  def playAgain: View = {

    read() match {
      case Some("1") => this
      case Some("2") => parent
      case _ =>

        out.write("""
         | Not sure what you mean :(
        """)

        playAgain
    }
  }
}
