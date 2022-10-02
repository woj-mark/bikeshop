package bikeshop.programs

import bikeshop.services.Orders
import bikeshop.services.ShoppingBasket
import bikeshop.http.PaymentClient  
import bikeshop.domain.checkout.Card
import bikeshop.domain.payment._
import bikeshop.domain.authentication._
import bikeshop.domain.order._

import cats.implicits._

import cats.Monad

final case class Checkout[F[_]:Monad](
    payments : PaymentClient[F],
    shopBasket: ShoppingBasket[F],
    orders:Orders[F] ){

def process(userID: UserID, card:Card): F[OrderID] =
    for{
        basket <- shopBasket.get(userID)
        pmtID <- payments.process(Payment(userID, basket.total, card))
        ordID <- orders.create(userID, pmtID, basket.bikes, basket.total)
        _ <- shopBasket.delete(userID)
    } yield ordID


    }