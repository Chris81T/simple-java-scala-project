package de.geeksession.api

import net.liftweb.http.rest.RestHelper
import net.liftweb.json.JsonAST.{JInt, JString}
import net.liftweb.util.Helpers
import net.liftweb.common.Box
import de.geeksession.CalculatorService
import javax.naming.InitialContext

/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 6/1/13
 * Time: 1:31 PM
 * To change this template use File | Settings | File Templates.
 */
object SimpleResourceHelper extends RestHelper with SimpleResource {

  private def calculatorService: CalculatorService = {
    val context = new InitialContext
    context.lookup(CalculatorService.JNDI).asInstanceOf[CalculatorService]
  }

  serve {

    case "api" :: "say" :: "something" :: Nil JsonGet _ => JString("Hello Geek!")

    case "api" :: "calc" :: aStr :: "plus" :: bStr :: Nil JsonGet _ => JInt(calc(aStr, bStr, calculatorService.add).getOrElse(-1))
    case "api" :: "calc" :: aStr :: "minus" :: bStr :: Nil JsonGet _ => JInt(calc(aStr, bStr, calculatorService.sub).getOrElse(-1))
    case "api" :: "calc" :: aStr :: "mul" :: bStr :: Nil JsonGet _ => JInt(calc(aStr, bStr, calculatorService.mul).getOrElse(-1))
    case "api" :: "calc" :: aStr :: "div" :: bStr :: Nil JsonGet _ => JInt(calc(aStr, bStr, calculatorService.div).getOrElse(-1))
    case "api" :: "calc" :: aStr :: "modulo" :: bStr :: Nil JsonGet _ => JInt(calc(aStr, bStr, calculatorService.mod).getOrElse(-1))

  }

}

trait SimpleResource {

  protected def calc(aStr: String, bStr: String, f: (Int, Int) => Int) : Box[BigInt] = for {
    a <- Helpers.asInt(aStr) ?~ "a is invalid"
    b <- Helpers.asInt(bStr) ?~ "b is invalid"
  } yield f(a, b)

}
