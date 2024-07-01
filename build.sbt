ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.14"

lazy val root = (project in file("."))
  .settings(
    name := "MorseCodeTranslator"
  )

libraryDependencies ++= Seq(
  "org.mockito" %% "mockito-scala-scalatest" % "1.16.37",
  "org.scalatest" %% "scalatest" % "3.2.10" % Test
)
