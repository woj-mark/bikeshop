
package bikeshop.domain

import java.util.UUID
import squants.market._
import bikeshop.domain.company._
import bikeshop.domain.category._

import cats.effect._
import cats.syntax.all._

object bike {

case class BikeID(value: UUID)
case class BikeName(value: String)
case class BikeInfo(value: String)


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