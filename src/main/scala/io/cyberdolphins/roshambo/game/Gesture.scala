package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

sealed trait Gesture

case object Rock extends Gesture
case object Scissors extends Gesture
case object Paper extends Gesture

case object Lizard extends Gesture
case object Spock extends Gesture
