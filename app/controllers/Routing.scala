package controllers

import play.api.mvc.{Action, Controller}
import play.api.cache.Cache
import jsmessages.api.JsMessages
import play.api.Play.current
import play.api.Routes

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 14/08/12
 * Time: 20:58
 */

object Routing extends Controller {

  def index = Action {
    implicit request =>
      Ok(views.html.routing.index())
  }

  /**
   * Makes some routes available via javascript
   */
  def javascriptRoutes = Action { implicit request =>
    import routes.javascript._
    // We cache the routes so we don't have to generate them each request
    Ok(Cache.getOrElse("javascriptRoutes", 60*60*24){
      // The routes are stores under the 'jsRoutes' object in Javascript
      Routes.javascriptRouter("jsRoutes")(
        Application.index, I18N.index
      )
    }).as("text/javascript")
  }

}

