package bikeshop.services

import bikeshop.domain.authentication._
import bikeshop.domain.order._
import squants.market.Money
import bikeshop.domain.bike._

/*
Algebra for quering past order and persisting new ones.
*/

trait Orders[F[_]] {
    def get(
        userID:UserID,
        orderID:OrderID
    ):F[Option[Order]]
  
    def findBy(userID:UserID):F[List[Order]]

    def create(
        userID:UserID,
        paymentID:PaymentID,
        bikes: List[Bike],
        total: Money
    ):F[OrderID]
  
}
