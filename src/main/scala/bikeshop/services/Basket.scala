package bikeshop.services

import bikeshop.domain.bike._
import bikeshop.domain.authentication._
import bikeshop.domain.basket._
import cats.implicits._

/*
Algebra enabling CRUD operations on the shopping basket
*/

trait ShoppingBasket[F[_]] {
    def add(
        userId: UserID,
        bikeID: BikeID,
        quantity:Quantity
    ) : F[Unit]
  
    def get(userId:UserID):F[BasketTotal]
    def delete(userId:UserID): F[Unit]
    def removeBike(userId:UserID, bikeID:BikeID):F[Unit]
    def update(userId:UserID, basket:Basket):F[Unit]

}
