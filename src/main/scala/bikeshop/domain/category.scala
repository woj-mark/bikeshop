
package bikeshop.domain

import java.util.UUID

import derevo.derive
import derevo.circe.magnolia.{ decoder, encoder }
import io.circe.{ Decoder, Encoder }
import derevo.cats._
import cats.instances.uuid


object category{

@derive(decoder, encoder, eqv, show)
case class CategoryID(value: UUID)

@derive(decoder, encoder, eqv, show)
case class CategoryName(value: String)


@derive(decoder, encoder, eqv, show)
case class Category(id:CategoryID, name: CategoryName)
}