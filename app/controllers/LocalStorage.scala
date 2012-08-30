package controllers

import play.api.mvc._

object LocalStorage extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.localstorage.index())
  }

}