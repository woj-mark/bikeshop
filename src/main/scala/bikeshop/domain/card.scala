// package bikeshop.domain

// import io.circe.refined._


// object card {


//   type CardRgx = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$"
//   type CardNamePredicate = String Refined MatchesRegex[Rgx]
//   type CardNumberPr = Long Refined Size[16]
//   type CardExpirationPred = String Refined (Size[4] And ValidInt)



//   case class CardName(value: CardNameValue)



//     case class card(
//         name : CardName,
//         number: CardNumber,
//         expirationDate: CardExpirationDate
//         cvv: CVVNumber
//     )
  


// }
