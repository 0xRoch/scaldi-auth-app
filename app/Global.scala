import anorm.Id
import models.User
import play.api._

object Global extends GlobalSettings {

  override def onStart(app: Application) {
    InitialData.insert()
    Logger.info("Application has started")
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