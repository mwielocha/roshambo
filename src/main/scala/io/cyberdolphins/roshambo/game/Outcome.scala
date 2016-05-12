package io.cyberdolphins.roshambo.game

/**
 * Created by Mikolaj Wielocha on 12/05/16
 */

sealed trait Outcome

case object Vistory extends Outcome
case object Defeat extends Outcome
case object Tie extends Outcome

