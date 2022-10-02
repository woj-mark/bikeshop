package bikeshop.http

import bikeshop.domain.order._
import bikeshop.domain.payment._
import cats.implicits._


trait PaymentClient[F[_]] {
  def process(payment:Payment):F[PaymentID] //Temporarilly wrapped around the F[] to allow being put into for comprehension in the checkout
}

