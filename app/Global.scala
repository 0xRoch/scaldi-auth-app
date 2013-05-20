import anorm.Id
import controllers.auth.AuthModule
import controllers.ConfigModule
import models.User
import play.api._
import scaldi.ClassIdentifier

object Global extends GlobalSettings {

  private lazy val applicationModule = new AuthModule :: new ConfigModule

  override def onStart(app: Application) {
    InitialData.insert()
    Logger.info("Application has started")
  }


  override def getControllerInstance[A](controllerClass: Class[A]) =
    applicationModule.getBinding(List(ClassIdentifier(controllerClass))) match {
      case Some(binding) => binding.get map (_.asInstanceOf[A]) getOrElse
        (throw new IllegalStateException(s"Controller for class $controllerClass is explicitly un-bound!"))
      case None =>
        throw new IllegalStateException(s"Controller for class $controllerClass not found!")
    }

  /**
   * Initial set of data to be imported
   * in the sample application.
   */
  object InitialData {

    def date(str: String) = new java.text.SimpleDateFormat("yyyy-MM-dd").parse(str)

    def insert() = {

      if(User.findAll.isEmpty) {

        Seq(
          User(Id(1), "myuser@gmail.com", "secret")
        ).foreach(User.create)

      }

    }

  }

}