package controllers

import play.api.mvc._

object SessionJs extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.sessionjs.index())
  }

}