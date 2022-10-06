package bikeshop.http.routes

import bikeshop.services.Bikes


import cats.Monad
import org.http4s.dsl.Http4sDsl


final case class BikeRoutes[F[_]:Monad](
    bikes:Bikes[F]
) extends Http4sDsl[F]{

private[routes] val prefixPath = "/bikes"

object CompanyQueryParam extends OptionalQueryParamDecoderMatcher[CompanyParam]("company")


}