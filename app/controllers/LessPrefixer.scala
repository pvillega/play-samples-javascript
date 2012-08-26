package controllers

import play.api.mvc._

object LessPrefixer extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.lessprefixer.index())
  }

}