package controllers

import play.api.mvc._

object EmailBoilerplate extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.emailboilerplate.index())
  }

}