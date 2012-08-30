package controllers

import play.api.mvc._

object WebWorkers extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.webworkers.index())
  }

}