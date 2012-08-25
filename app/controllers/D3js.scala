package controllers

import play.api.mvc._

object D3js extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.d3js.index())
  }

}