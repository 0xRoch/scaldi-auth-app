import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "scaldi-auth-app"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    jdbc,
    anorm
  )

  lazy val auth = file("modules/auth")

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  ).dependsOn(auth)

}
