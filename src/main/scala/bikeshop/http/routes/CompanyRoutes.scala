package bikeshop.http.routes

import bikeshop.services.Companies
import bikeshop.services.Bikes

import bikeshop.domain.company._

import cats.implicits._

import cats.Monad
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router
import org.http4s.circe.CirceEntityEncoder._
import io.circe.Decoder
import org.http4s.server.Router



// import org.http4s.dsl.Http4sDsl
// import org.http4s.server.Router

/*
Representing the routes (endpoints) for bikes 
*/


final case class CompanyRoutes[F[_]:Monad](
    companies:Companies[F]
) extends Http4sDsl[F]{

//Root of the endpoint
private[routes] val prefixPath = "/companies"

//http routes definiing the endpoints via pattern matching
//Builds a response with code 200

  private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
      //Ok(companies.getAll)
      Ok("OK")
  }


  //routes use the Router that lets us add a prefixPath to a group of endpoints
  //denoted in HTTProutes
  val routes: HttpRoutes[F] = Router(
    prefixPath -> httpRoutes
  )

}