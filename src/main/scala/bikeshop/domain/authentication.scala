package bikeshop.domain

import java.util.UUID


object authentication {

case class UserName(value: String)
case class UserID(value: UUID)

case class  Password(value: String)
case class EncryptedPassword(value:String)

case class UserWithPassword(
    id: UserID,
    name: UserName,
    password: EncryptedPassword
)
}
