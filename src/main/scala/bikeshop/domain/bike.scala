
package bikeshop.domain

import java.util.UUID
import squants.market._
import bikeshop.domain.company._
import bikeshop.domain.category._
import bikeshop.optics.uuid


import cats.effect._
import cats.syntax.all._

import derevo.cats._
import derevo.circe.magnolia._
import derevo.derive
import eu.timepit.refined.api.Refined
import eu.timepit.refined.auto._
import eu.timepit.refined.cats._
import eu.timepit.refined.string.{ Uuid, ValidBigDecimal }
import eu.timepit.refined.types.string.NonEmptyString
import io.estatico.newtype.macros.newtype
import squants.market._


/*
Domain model for the bike products on the website
Each bike should have a unique identifier
Price fields (GBP) represented using smarkets library
*/


object bike {

@derive(decoder, encoder, keyDecoder, keyEncoder, eqv, show, uuid)    
@newtype
case class BikeID(value: UUID)

 @derive(decoder, encoder, eqv, show)
case class BikeName(value: String)

@derive(decoder, encoder, eqv, show)
case class BikeInfo(value: String)

//@derive(decoder, encoder, eqv, show)
case class Bike(
    id: BikeID,
    name: BikeName,
    company: Company,
    category: Category,
    info: BikeInfo,
    price : Money
)


case class CreateBike(
    name: BikeName,
    info: BikeInfo,
    companyID : CompanyID,
    categoryID : CategoryID
)


case class UpdateBike(
    id: BikeID,
    price: Money
)
}