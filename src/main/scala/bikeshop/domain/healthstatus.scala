package bikeshop.domain

import monocle.Iso
import cats.effect.implicits._
import io.circe.Encoder

//The web app has to report its health status
//The healthcheck investigates the status of the DB and cache connection

object healthstatus {

//Define the status as a sealed trait to define sum type (ADT) 
// i.e. is OK or NotResponsive
sealed trait Status
  object Status {
    case object Ok       extends Status
    case object NotResponsive extends Status

//The status is isomorphic to boolean
//(one-to-one correspondece/mapping in abstract algebra/graph thory)
    val mapToBoolean: Iso[Status, Boolean] =
      Iso[Status, Boolean] {
        case Ok        => true
        case NotResponsive => false
      }(if (_) Ok else NotResponsive)


implicit val jsonEncoder: Encoder[Status] =
Encoder.forProduct1("status")(_.toString)
}

case class CacheStatus(value:Status)

case class DBStatus(value: Status)

//Product ADT to define the condition of the backend
case class BackendStatus(
      cache: CacheStatus,
      db: DBStatus
  )

}

