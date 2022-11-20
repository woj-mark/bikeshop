package bikeshop.http

import java.util.UUID
import bikeshop.domain.bike._
import bikeshop.domain.order._

import cats.implicits._


  
object vars {
  protected class UUIDVar[A](f: UUID => A) {
    def unapply(str: String): Option[A] =
      Either.catchNonFatal(f(UUID.fromString(str))).toOption
  }

  object BikeIdVar  extends UUIDVar(BikeID.apply)
  object OrderIdVar extends UUIDVar(OrderID.apply)
}

