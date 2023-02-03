import sbt._

object Dependencies {
  private val catsVersion = "2.8.0"
  private val scalacheckVersion = "1.15.4"
  private val scalatestVersion = "3.2.15"

  val cats = "org.typelevel" %% "cats-core" % catsVersion
  val scalacheck = "org.scalacheck" %% "scalacheck" % scalacheckVersion
  val scalatest = "org.scalatest" %% "scalatest" % scalatestVersion
}
