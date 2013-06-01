package bootstrap.liftweb

import net.liftweb._

import common.Full
import http._
import http.Html5Properties
import de.geeksession.api.{SimpleResourceHelper, SimpleResource}


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    // where to search snippet
    LiftRules.addToPackages("de.geeksession")

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart =
      Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)

    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd =
      Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) =>
      new Html5Properties(r.userAgent))

    // Sets the generation of radio elements globally - if vertical radio row is required, use the foundation's inline list
    SHtml.ChoiceHolder.htmlize = c => (<li><label>{c.xhtml}{c.key.toString}</label></li>)

    // Add REST resources
    LiftRules.statelessDispatch.append(SimpleResourceHelper)

  }
}

