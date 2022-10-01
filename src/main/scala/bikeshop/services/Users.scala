package bikeshop.services

import bikeshop.domain.authentication._

/*
Algebra for storing and and finding user information and passwords
*/

trait Users[F[_]] {
  def get(username:UserName):F[Option[UserWithPassword]]
  def create(username:UserName, password:EncryptedPassword)
}
