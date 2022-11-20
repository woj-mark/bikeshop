
package bikeshop.http.routes


import bikeshop.services.ShoppingBasket
import bikeshop.domain.basket._
import bikeshop.http.authentication.users._


import cats.Monad
import cats.syntax.all._
import org.http4s._
import org.http4s.circe.CirceEntityEncoder._
import org.http4s.circe._
import org.http4s.dsl.Http4sDsl
import org.http4s.server._
import bikeshop.domain.basket
import bikeshop.http.vars.BikeIdVar


//Using a JSON decoder as a constraint- it lets us decode our request as the required entity A, given Decoder[A]
//Using AuthedRoutes instead of httpRoutes to enable accessing the authenticarted user in every request
final case class BasketRoutes[F[_]:JsonDecoder:Monad](shoppingBasket:ShoppingBasket[F]) extends Http4sDsl[F]{
    private[routes] val prefixPath = "/basket"

    private val httpRoutes: AuthedRoutes[CommonUser, F] = AuthedRoutes.of {
    
    // Get basket
    case GET -> Root as user =>
      Ok("returning basket for now")
      //Ok(shoppingBasket.get(user.value.id))


    // Add bikes to the basket
    case ar @ POST -> Root as user =>
      ar.req.asJsonDecode[Basket].flatMap {
        _.bikes
          .map {
            case (id, quantity) =>
              shoppingBasket.add(user.value.id, id, quantity)
          }
          .toList
          .sequence *> Created()
      }

      
    // Modify bikes inthe basket
    case ar @ PUT -> Root as user =>
      ar.req.asJsonDecode[Basket].flatMap { basket =>
        shoppingBasket.update(user.value.id, basket) *> Ok()
      }

    // Remove bike from the basket- use path variable BikeIdVar
    case DELETE -> Root / BikeIdVar(bikeID) as user =>
      shoppingBasket.removeBike(user.value.id, bikeID) *> NoContent()
  }


   //Adding a prefixPath to a group of endpoints denoted in the routes
  //The routes take AuthedRoutes middleware as an argument to implement authentication
  def routes(authMiddleware: AuthMiddleware[F, CommonUser]): HttpRoutes[F] = Router(
    prefixPath -> authMiddleware(httpRoutes))

}
