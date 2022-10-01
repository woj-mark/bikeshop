package bikeshop.domain

import squants.market._
import bikeshop.domain.bike._
import bikeshop.domain.shopCart._

import java.util.UUID


object order {
  
    case class Order(
        id : OrderID,
        paymentID : PaymentID,
        bikes : Map[BikeID, Quantity],
        total : Money
    )

    case class OrderID(value: UUID)

    case class PaymentID(value: UUID)
}
