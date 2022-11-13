package bikeshop.services

import bikeshop.domain.authentication._
import bikeshop.domain.order._
import squants.market.Money
import bikeshop.domain.bike._
import cats.data.NonEmptyList

/*
Algebra for quering past order and persisting new ones.
The orders to be persisted in the persistance layer
*/

trait Orders[F[_]] {
    def get(
        userID:UserID,
        orderID:OrderID
    ):F[Option[Order]]
  
    def findBy(userID:UserID):F[List[Order]]

    //Use non-empty list for bikes to ensure that at least one bike is included
    def create(
        userID:UserID,
        paymentID:PaymentID,
        bikes: List[Bike],
        total: Money
    ):F[OrderID]
  
}
