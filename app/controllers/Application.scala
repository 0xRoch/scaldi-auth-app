package controllers

import auth.SecurityModule
import play.api.mvc._
import scaldi.{Module, Injectable}
import models.User

object Application extends Controller {}

class ConfigModule extends Module {
  bind [SecurityModule] as 'secure to new SecurityImpl
}
 
class SecurityImpl extends SecurityModule with Injectable {
  def authenticate(username: String, password: String): Boolean = {
    User.authenticate(username, password) match {
     case Some(user:User) => true
     case _ => false
    }
  }
}