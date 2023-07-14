ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "contracts"
  )

// add ergo-appkit v5.0.3 as a dependency
libraryDependencies += "org.ergoplatform" %% "ergo-appkit" % "5.0.3"