package io.cyberdolphins.roshambo.views

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait View {

  val parent: View

  val in: Input

  val out: Output

  def text: String

  def next: View

  def read(): Option[String] = in.read

  def apply(): Option[View] = {
    out.write(text)
    next()
  }
}

abstract class AbstractView(override val parent: View)(implicit val in: Input, out: Output) extends View


