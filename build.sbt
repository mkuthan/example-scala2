import Dependencies._
import Settings._

lazy val exampleScala = (project in file("."))
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      cats,
      scalacheck % Test,
      scalatest % Test
    )
  )
