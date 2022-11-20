package bikeshop.domain

import java.util.UUID

import bikeshop.optics.uuid


import derevo.cats._
import derevo.circe.magnolia.{ decoder, encoder }
import derevo.derive
import eu.timepit.refined.auto._
import eu.timepit.refined.types.string.NonEmptyString
import io.circe._
//import io.circe.refined._
import io.estatico.newtype.macros.newtype

/*
Domain model for users and domain authentication
JSON Web Tokens (JWT) is used for authentication
Auth responsible for validaiton of encrypted passwords
*/
object authentication {

@derive(decoder, encoder, eqv, show)
@newtype
case class UserName(value: String)

@derive(decoder, encoder, eqv, show, uuid)
@newtype
case class UserID(value: UUID)


case class JwtToken(value: String)
  
  @derive(decoder, encoder, eqv, show)
  @newtype
case class  Password(value: String)


  @derive(decoder, encoder, eqv, show)
  @newtype
case class EncryptedPassword(value:String)

// case class UserWithPassword(
//     id: UserID,
//     name: UserName,
//     password: EncryptedPassword
// )
}
