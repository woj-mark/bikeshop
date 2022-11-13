package bikeshop.http.routes

import bikeshop.services.HealthStatus
import bikeshop.domain.healthstatus._

import cats.Monad
import org.http4s._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router

//Representing routes reporting the status od the cache (Redis) and database (postgreSQL)
final case class HealthStatusRoutes[F[_]:Monad](healthStatus:HealthStatus[F]) extends Http4sDsl[F]{
private[routes] val prefixPath = "/healthstatus"

private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
case GET -> Root  =>
    Ok("Health status to be displayed here")
    //Ok(healthStatus.status)
}

val routes: HttpRoutes[F] = Router(
    prefixPath -> httpRoutes
)
}



