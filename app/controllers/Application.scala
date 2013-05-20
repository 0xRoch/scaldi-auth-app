package controllers

import auth.SecurityService
import play.api.mvc._
import scaldi.{Module, Injectable}
import models.User

class Application extends Controller with Injectable{
  // more injection stuff going on here
}

class ConfigModule extends Module {
  // controllers
  binding to new Application

  // other stuff
  bind [SecurityService] as 'secure to new SecurityImpl
}
 
class SecurityImpl extends SecurityService {
  def authenticate(username: String, password: String): Boolean = {
    User.authenticate(username, password) match {
     case Some(user:User) => true
     case _ => false
    }
  }
}