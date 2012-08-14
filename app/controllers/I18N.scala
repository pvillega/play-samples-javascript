package controllers

import play.api.mvc.{Action, Controller}
import play.api.cache.Cache
import jsmessages.api.JsMessages
import play.api.Play.current

/**
 * Created with IntelliJ IDEA.
 * User: pvillega
 * Date: 14/08/12
 * Time: 20:58
 */

object I18N extends Controller {

  def index = Action { implicit request =>
    Ok(views.html.i18n.index())
  }

  /**
   * Exports the subset of I18N we may need on Javascript
   * @return the subset of I18N we may need on Javascript
   */
  def jsMessages = Action { implicit request =>
    //We cache the results to avoid accessing the disk every time
    Ok(Cache.getOrElse("jsI18N", 60*60*24){
      //This allows us to export a subset of the I18N messages by providing the relevant keys.
      // If we don't, we will export all messages
      JsMessages.subset(Some("window.Messages"))(
        "test.message",
        "test.message2"
      )
    }).as("text/javascript")
  }

}

