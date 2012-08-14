package controllers

import play.api.mvc._

object Gridster extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.gridster.index())
  }

}