package bikeshop.http.routes

import bikeshop.services.Bikes
import bikeshop.domain.company._
import bikeshop.domain.bike._


import cats.Monad
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes

import org.http4s.circe.CirceEntityEncoder._
import org.http4s.server.Router



final case class BikeRoutes[F[_]:Monad](
    bikes:Bikes[F]
) extends Http4sDsl[F]{

private[routes] val prefixPath = "/bikes"

object CompanyQueryParam extends OptionalQueryParamDecoderMatcher[CompanyParam]("company")

private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
case GET -> Root :? CompanyQueryParam(company) =>
    Ok("OK")
//Ok(company.fold(bikes.getAll)(b => bikes.findBy(b.toDomain)))
}



}