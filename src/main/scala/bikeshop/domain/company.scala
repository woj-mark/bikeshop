package bikeshop.domain

import java.util.UUID
import derevo.derive
import derevo.circe.magnolia.{ decoder, encoder }
import io.circe.{ Decoder, Encoder }
import derevo.cats._
import eu.timepit.refined.types.string.NonEmptyString
import bikeshop.ext.http4s.queryParam




object company{

@derive(decoder, encoder, eqv, show) //This needs to be change to UUID, temporarily an Int
case class CompanyID(value: Int)

@derive(decoder, encoder, eqv, show)
case class CompanyName(value: String)

@derive(decoder, encoder, eqv, show)
case class Company(id:CompanyID, name: CompanyName)


@derive(queryParam, show)
@newtype
case class CompanyParam(value: NonEmptyString) {
def toDomain: BrandName = BrandName(value.toLowerCase.capitalize)
  }
}