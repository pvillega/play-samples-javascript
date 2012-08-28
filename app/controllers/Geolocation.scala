package controllers

import play.api.mvc._

object Geolocation extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.geolocation.index())
  }

}