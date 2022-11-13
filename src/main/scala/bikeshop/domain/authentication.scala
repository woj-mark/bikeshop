package bikeshop.domain

import java.util.UUID



/*
Domain model for users and domain authentication
JSON Web Tokens (JWT) is used for authentication

Auth responsible for validaiton of encrypted passwords
*/


object authentication {

case class UserName(value: String)
case class UserID(value: UUID)

case class JwtToken(value: String)

case class  Password(value: String)
case class EncryptedPassword(value:String)

case class UserWithPassword(
    id: UserID,
    name: UserName,
    password: EncryptedPassword
)
}
