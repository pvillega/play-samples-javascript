package controllers

import play.api.mvc._

object SemanticElements extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.semanticelements.index())
  }

}