package controllers

import play.api.mvc._

object Offline extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.offline.index())
  }

  /**
   * @return the Manifest file used for caching resources in HTML 5
   */
  def cacheFile() = Action {
    implicit request =>
      Ok.sendFile(new java.io.File("public/cache.manifest")).as("text/cache-manifest")
  }

}