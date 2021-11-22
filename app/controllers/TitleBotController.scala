
package controllers {

  import org.jsoup.Jsoup
  import org.jsoup.nodes.{Document, Element}

  import javax.inject._
  import play.api._
  import play.api.mvc._
  // import models._

  import play.api.data._
  import play.api.data.Forms._
  import play.api.i18n._

/*
 import net.ruippeixotog.scalascraper.dsl.DSL._
 import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
 import net.ruippeixotog.scalascraper.dsl.DSL.Parse._
 import net.ruippeixotog.scalascraper.browser.JsoupBrowser
 import net.ruippeixotog.scalascraper.model._
 */

//case class webpage(name: String)

  object TitleBotCrawler {
    def title(webpage : String) : String = {
      var document :Document = Jsoup.connect(webpage).get()
      var title = document.title()
      /*
      var website : String = "http://en.wikipedia.org/"
      val browser = JsoupBrowser()
      val doc = browser.get(website)
      val title = doc >> net.ruippeixotog.scalascraper.dsl.DSL.Extract.text("#title")
       */

      return title
    }
  }

  case class webPageData(webpage: String)

  /**
    * This controller creates an `Action` to handle HTTP requests to the
    * application's home page.
    */
  @Singleton
  class TitleBotController @Inject()(cc: ControllerComponents)
      extends AbstractController(cc)
      with I18nSupport{

    
    val webPageForm : Form[webPageData]  = Form(
      mapping(
        "WebPage" -> nonEmptyText
      )(webPageData.apply)(webPageData.unapply)
    )

    /**
      * Create an Action to render an HTML page.
      *
      * The configuration in the `routes` file means that this method
      * will be called when the application receives a `GET` request with
      * a path of `/`.
      * implicit request: Request[AnyContent] =>
      */

    def index()=Action { implicit request =>
      Ok(views.html.index(webPageForm))
    }

    def simpleFormPost() = Action { implicit request => //: Request[AnyContent] =>
      //val webPageData: webPageData = 
      webPageForm.bindFromRequest().fold(
        formWithErrors => {
          // Setup an Error Page. 
          BadRequest(views.html.error())


        },
        webpage => {
          // Handle Jsoup Code here.
          var website = webpage.webpage
          try {
            var title = TitleBotCrawler.title(website)
            Ok(views.html.titlepage(title))
          }
          catch {
            case e: IllegalArgumentException => BadRequest(views.html.error());

          }
        }
      )
    }

  } // TitleBotController
} // controllers
