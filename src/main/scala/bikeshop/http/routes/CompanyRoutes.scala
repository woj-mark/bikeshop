package bikeshop.http.routes

import bikeshop.services.Companies

import cats.Monad
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router
import org.http4s.circe.CirceEntityEncoder._

// import org.http4s.dsl.Http4sDsl
// import org.http4s.server.Router


final case class CompanyRoutes[F[_]:Monad](
    companies:Companies[F]
) extends Http4sDsl[F]{


private[routes] val prefixPath = "/companies"

  private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
        Ok(companies.getAll)
  }

  val routes: HttpRoutes[F] = Router(
    prefixPath -> httpRoutes
  )
}