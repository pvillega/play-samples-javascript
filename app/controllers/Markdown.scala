package controllers

import play.api.mvc._
import models.Sample
import play.api.data.Form
import play.api.data.Forms._
import java.util.Scanner
import java.io.{InputStreamReader, FileWriter, FileReader, File}
import javax.script.ScriptContext
import javax.script.ScriptEngineManager
import javax.script.Bindings

object Markdown extends Controller {

  //sample form
  val sampleForm: Form[Sample] = Form(
    mapping(
      "text" -> nonEmptyText
    )(Sample.apply)(Sample.unapply)
  )

  // a sample of markdown text to be shown in the viewer
  val markdownText =
    """
      |Hi there!
      |=============
      |
      |I'm *Pere Villega*, a software developer from Barcelona (now living in Dublin). I like coding, learning new stuff and creating apps that solve problems for people.
    """.stripMargin

  def index = Action {
    implicit request =>
      Ok(views.html.markdown.index(sampleForm, markdownText, convertToHtml(markdownText) ))
  }

  /**
   * Converts the given markdown into HTML
   * @param markdown the markdown to turn into HTML
   */
  private def convertToHtml(markdown: String) = {
    val manager = new ScriptEngineManager()
    val engine = manager.getEngineByName("javascript")

    val b = engine.createBindings().asInstanceOf[Bindings]
    val f = new File("public/javascripts/showdown.js")
    val reader = new FileReader(f)

    try {
      b.put("markdownText", markdown)
      engine.setBindings(b, ScriptContext.ENGINE_SCOPE);

      engine.eval(reader).asInstanceOf[String]
    }
    catch {
      case e: javax.script.ScriptException =>
        "The script had an error: " + e.getMessage();
    }
  }

}