package controllers

import play.api.mvc._

object TheJit extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.thejit.index())
  }

}