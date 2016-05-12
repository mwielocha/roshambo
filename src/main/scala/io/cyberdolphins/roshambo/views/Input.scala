package io.cyberdolphins.roshambo.views

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

trait Input {
  def read: Option[String]
}

object EmptyInput extends Input {
  def read = None
}

