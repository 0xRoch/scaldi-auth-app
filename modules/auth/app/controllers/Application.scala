package controllers.auth

import play.api.mvc._
import scaldi.{Injector, Injectable}

object Application extends Controller {
  
  def index = Action {
    // inject ModSec here
    ModSec.secure.authenticate("myuser@gmail.com", "secret") match {
      case true => Ok
      case _ => Forbidden
    }
  }
  
}

trait SecurityModule {
  def authenticate(username: String, password: String): Boolean
}
 
class SecuritySample extends SecurityModule with Injectable {
  def authenticate(username: String, password: String): Boolean = false
}
 
class ModSec(implicit inj: Injector) extends Injectable {
  def secure = inject [SecurityModule] (identified by 'secure and by default new SecuritySample)
}