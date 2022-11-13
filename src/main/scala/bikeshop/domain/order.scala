package bikeshop.domain

import squants.market._
import bikeshop.domain.bike._
import bikeshop.domain.basket._
import cats.implicits._
import io.estatico.newtype.macros.newtype

import java.util.UUID
import io.estatico.newtype.NewType


/*
Domain model for the payments
PaymentID to be provided by a 3rd party client
*/


object order {
  
    case class Order(
        id : OrderID,
        paymentID : PaymentID,
        bikes : Map[BikeID, Quantity],
        total : Money
    )

    case class OrderID(value: UUID)

    @newtype
    case class PaymentID(value: UUID)
}
