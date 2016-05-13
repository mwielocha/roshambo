# Roshambo
A game of Rock Paper Scissors

# Testing
As simple as `sbt test`

# Running from sbt
Just do `sbt run`

# Building
Assembly plugin included, just do `sbt assembly` 
and then `java -jar target/scala-2.11/roshambo-assembly-1.0.jar`

# Contributing

Feel free to extend the game!
It is super-easy to add new variants using `GameLogicDsl`, example:

A game of rock beats everything:

```scala

 val rockAlwaysWins = GameLogic { implicit builder =>

    Rock ~> Scissors 
    Rock ~> Paper 
    Rock ~> Lizard
    Rock ~> Spock

  }

```

Rock Paper Scissors reversed:

```scala

 val scissorsRockPaper = GameLogic { implicit builder =>

    Scissors ~> Rock ~> Paper ~> Scissors

  }

```

Unbalanced french version:

```scala

 val  pierrePapierCiseauxPuits = GameLogic { implicit builder =>

    Pierre ~> Ciseaux ~> Papier ~> Pierre
    
    Puits ~> Pierre
    
    Puits ~> Ciseaux
    
    Papier ~> Puits

  }

```
For that last one you need to add french gestures.

# Enjoy!

