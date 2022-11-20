package bikeshop.http.authentication


import bikeshop.domain.authentication._

import derevo.cats.show
import derevo.circe.magnolia.{ decoder, encoder }
import derevo.derive
import dev.profunktor.auth.jwt._
import io.estatico.newtype.macros.newtype



//Given that we don't know out users at this stage, they are not represented in the domain model
//Users shall be able to register and login to the website using valid credentials

//We distinguish between a user, user with password, common user (no password) and an admin

//JWT tokens to be used for authentication with help of Http4s JWT Auth which offers authentication
//on top of Http4s and JWT Scala

object users {

//JWT auth for the admin and the user
    @newtype case class AdminJwtAuth(value: JwtSymmetricAuth)
  @newtype case class UserJwtAuth(value: JwtSymmetricAuth)

  
  @derive(decoder, encoder, show)
  case class User(id: UserID, name: UserName)

  @derive(decoder, encoder)
  case class UserWithPassword(id: UserID, name: UserName, password: EncryptedPassword)

  @derive(show)
  @newtype
  case class CommonUser(value: User)

  @derive(show)
  @newtype
  case class AdminUser(value: User)



}
