package bikeshop.domain

import bikeshop.domain.authentication._
import squants.market.Money
import bikeshop.domain.checkout.Card
import cats.implicits._



/*
Domain model for payments
*/


object payment {
  
    case class Payment(
        userID:UserID,
        total:Money,
        card:Card
    )


}
