package io.cyberdolphins.roshambo.views

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait Output {
  def write(s: String): Unit
}

object EmptyOutput extends Output {
  def write(s: String) = ()
}

