package bikeshop.domain

import java.util.UUID
import derevo.derive
import derevo.circe.magnolia.{ decoder, encoder }
import io.circe.{ Decoder, Encoder }
import derevo.cats._
import io.estatico.newtype.macros.newtype



object company{

@derive(decoder, encoder, eqv, show) //This needs to be change to UUID, temporarily an Int
case class CompanyID(value: Int)

@derive(decoder, encoder, eqv, show)
case class CompanyName(value: String)

@derive(decoder, encoder, eqv, show)
case class Company(id:CompanyID, name: CompanyName)
}