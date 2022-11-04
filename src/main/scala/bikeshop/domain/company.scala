package bikeshop.domain

import java.util.UUID
import derevo.derive
import derevo.circe.magnolia.{ decoder, encoder }
import io.circe.{ Decoder, Encoder }
import derevo.cats._
import bikeshop.ext.http4s.queryParam
import io.estatico.newtype.macros.newtype
import derevo.derive
import eu.timepit.refined.types.string._




object company{

@derive(decoder, encoder, eqv, show) //This needs to be change to UUID, temporarily an Int
case class CompanyID(value: Int)

@derive(decoder, encoder, eqv, show)
case class CompanyName(value: NonEmptyString)

@derive(decoder, encoder, eqv, show)
case class Company(id:CompanyID, name: CompanyName)


@derive(queryParam, show)
@newtype
case class CompanyParam(value: NonEmptyString) {
def toDomain: CompanyName = CompanyName(value)
  } 
  
}

 