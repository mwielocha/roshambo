
// Generated with scalagen

lazy val root = (project in file(".")).
  settings(
    name := "roshambo",
    version := "1.0",
    scalaVersion := "2.11.7"
  )

mainClass in (Compile, run) := Some("io.cyberdolphins.roshambo.Run")
mainClass in (Compile, assembly) := Some("io.cyberdolphins.roshambo.Run")

libraryDependencies ++= Seq(
    "org.scalatest" %% "scalatest" % "2.2.6" % "test"
  )

