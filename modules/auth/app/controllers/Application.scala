package controllers.auth

import play.api.mvc._
import scaldi.{Module, Injector, Injectable}

class Application(implicit ibj: Injector) extends Controller with Injectable {
  val secure = inject [SecurityService] (identified by 'secure and by default new SecuritySample)

  def index = Action {
    // inject ModSec here
    secure.authenticate("myuser@gmail.com", "secret") match {
      case true => Ok
      case _ => Forbidden
    }
  }
  
}

trait SecurityService {
  def authenticate(username: String, password: String): Boolean
}
 
class SecuritySample extends SecurityService with Injectable {
  def authenticate(username: String, password: String): Boolean = false
}

class AuthModule extends Module {
  binding to new Application
}