package bikeshop.http.routes

import bikeshop.services.Categories

import cats.Monad
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router
import org.http4s.circe.CirceEntityEncoder._


final case class CategoryRoutes[F[_]:Monad](
 categories:Categories[F]
) extends Http4sDsl[F]{
private[routes] val prefixPath = "/categories"

 private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
        Ok(categories.getAll)
  }

  
  val routes: HttpRoutes[F] = Router(
    prefixPath -> httpRoutes
  )
}
