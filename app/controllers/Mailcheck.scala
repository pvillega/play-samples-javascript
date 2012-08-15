package controllers

import play.api.mvc._

object Mailcheck extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.mailcheck.index())
  }

}