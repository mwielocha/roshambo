package io.cyberdolphins.roshambo.views

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

abstract class Menu(parent: View)(implicit override val in: Input, override val out: Output) extends AbstractView(parent) {

  type Selection = PartialFunction[String, View]

  def text: String

  def select: Selection

  override def next = read() match {

    case Some(selection) if select.isDefinedAt(selection) => select(selection)

    case Some(selection) =>
      out.write("Uknown option, plaese try again")
      this

    case None => Exit
  }
}
