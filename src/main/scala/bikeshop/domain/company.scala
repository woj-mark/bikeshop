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
import org.http4s.circe.CirceEntityEncoder._
import eu.timepit.refined.types.string.NonEmptyString



/*
Domain model for the bike companies business domain
The company should have a unique ID and name (cannot be replicated)
*/

object company{

@derive(decoder, encoder, eqv, show) 
 case class CompanyID(value: UUID)

@derive(decoder, encoder, eqv, show)
 case class CompanyName(value: NonEmptyString)

@derive(decoder, encoder, eqv, show)
case class Company(id:CompanyID, name: CompanyName)


@derive(queryParam, show)
case class CompanyParam(value: NonEmptyString) {
def toDomain: CompanyName = CompanyName(value)
  } 
  
}

