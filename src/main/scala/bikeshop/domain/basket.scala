package bikeshop.domain

import bikeshop.domain.bike._
import squants.market._


import java.util.UUID


/*
Domain model for the shopping basket
Shopping basket is a simple key-value store of bikes and their quantities
Total value of the cart in GBP
*/

object basket {
  
case class Basket(
    bikes: Map[BikeID, Quantity]
)

case class Quantity(value: Int)

case class BasketBike(bike: Bike, quantity:Quantity){
    def subTotal : Money = GBP(quantity.value * bike.price.amount)
}

case class BasketTotal(bikes:List[Bike], total: Money) 
}
