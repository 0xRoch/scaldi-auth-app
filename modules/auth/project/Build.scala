import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "auth"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(

  )

  lazy val scaldi = uri("git://github.com/D-Roch/scaldi.git")
  
  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  ).dependsOn(scaldi)

}
