package bikeshop.http.routes

import bikeshop.services.Bikes
import bikeshop.domain.company._
import bikeshop.domain.bike._
import bikeshop.ext.http4s.queryParam._
import bikeshop.ext.http4s.refined._


import org.http4s.circe._


import cats.Monad
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpRoutes

import org.http4s.circe.CirceEntityEncoder._
import org.http4s.server.Router


/*
Representing the routes (endpoints) for bikes 
There is a company query parameter for filtering the bikes in GET request
by company name
*/


//Abstract effect type which can at least provide a monad instance
final case class BikeRoutes[F[_]:Monad](
    bikes:Bikes[F]
) extends Http4sDsl[F]{

private[routes] val prefixPath = "/bikes"

object CompanyQueryParam extends OptionalQueryParamDecoderMatcher[CompanyParam]("company")


//Defining routes for the bikes, i.e. GET/
//Using the query parameter matcher to filter by company name
private val httpRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
case GET -> Root :? CompanyQueryParam(company) =>
    Ok("OK")
//NEEDS a decoded and encoderOk(company.fold(bikes.getAll)(b => bikes.findBy(b.toDomain)))
}



}