import Dependencies._
import Settings._

lazy val exampleScala = (project in file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      scalatest % Test
    )
  )
