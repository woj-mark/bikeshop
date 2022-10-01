package bikeshop.domain

import bikeshop.domain.bike._

import java.util.UUID


object shopCart {
  
case class ShopCart(
    bikes: Map[BikeID, Quantity]
)

case class Quantity(value: Int)


}
