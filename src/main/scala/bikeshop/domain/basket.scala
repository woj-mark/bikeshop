package bikeshop.domain

import bikeshop.domain.bike._
import squants.market._


import java.util.UUID

import derevo.cats._
import derevo.circe.magnolia.{ decoder, encoder }
import derevo.derive
import io.circe.{ Decoder, Encoder }
import io.estatico.newtype.macros.newtype
/*
Domain model for the shopping basket
Shopping basket is a simple key-value store of bikes and their quantities
Total value of the cart in GBP
*/

object basket {
  


@derive(decoder, encoder, eqv, show)
@newtype
case class Quantity(value: Int)

case class BasketBike(bike: Bike, quantity:Quantity){
    def subTotal : Money = GBP(quantity.value * bike.price.amount)
}

case class BasketTotal(bikes:List[Bike], total: Money) 

@derive(eqv, show)
@newtype   
case class Basket(
    bikes: Map[BikeID, Quantity]
)

object Basket {
    implicit val jsonEncoder: Encoder[Basket] =
      Encoder.forProduct1("bikes")(_.bikes)

    implicit val jsonDecoder: Decoder[Basket] =
      Decoder.forProduct1("bikes")(Basket.apply)
  }
}