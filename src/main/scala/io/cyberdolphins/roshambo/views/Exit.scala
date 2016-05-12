package io.cyberdolphins.roshambo.views

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

object Exit extends View {
  override val in = EmptyInput
  override val out = EmptyOutput
  override val parent = this
  override val text = ""
  override val next = this
  override def apply() = None
}

