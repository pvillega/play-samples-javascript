package controllers

import play.api.mvc._

object GoogleAnalytics extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.googleanalytics.index())
  }

}