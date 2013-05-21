import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "auth"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.angelsmasterpiece.scaldi" %% "scaldi" % "0.1.1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    resolvers += "Angelsmasterpiece repo" at "https://raw.github.com/OlegIlyenko/angelsmasterpiece-maven-repo/master"
  )

}
