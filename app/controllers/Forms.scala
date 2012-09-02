package controllers

import play.api.mvc._

object Forms extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.forms.index())
  }

}