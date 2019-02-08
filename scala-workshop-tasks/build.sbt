name := "Scala-workshop"
version := "0.1.0-SNAPSHOT"
organization := "com.example"
scalaVersion := "2.12.6"

lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.5"
lazy val scalaCheck = "org.scalacheck" %% "scalacheck" % "1.14.0"

libraryDependencies ++= Seq(
  scalaTest % Test,
  scalaCheck % Test
)
