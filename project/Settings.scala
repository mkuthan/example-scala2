import sbt._
import sbt.Keys._

object Settings {
  val commonSettings = Seq(
    scalaVersion := "2.13.10",
    scalacOptions := Seq(
      "-deprecation", // Emit warning and location for usages of deprecated APIs
      "-feature", // Emit warning and location for usages of features that should be imported explicitly
      "-explaintypes", // Explain type errors in more detail
      "-unchecked", // Enable additional warnings where generated code depends on assumptions
      "-Xlint", // Enable recommended warnings
      "-Wdead-code", // Warn when dead code is identified
      "-Wextra-implicit", // Warn when more than one implicit parameter section is defined
      "-Wmacros:both", // Lints code before and after applying a macro
      "-Wnumeric-widen", // Warn when numerics are widened
      "-Woctal-literal", // Warn on obsolete octal syntax
      "-Wunused:imports", // Warn if an import selector is not referenced
      "-Wunused:patvars", // Warn if a variable bound in a pattern is unused
      "-Wunused:privates", // Warn if a private member is unused
      "-Wunused:locals", // Warn if a local definition is unused
      "-Wunused:explicits", // Warn if an explicit parameter is unused
      "-Wunused:implicits", // Warn if an implicit parameter is unused
      "-Wvalue-discard", // Warn when non-Unit expression results are unused
    )
  )
}
