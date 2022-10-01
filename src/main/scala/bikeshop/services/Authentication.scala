package bikeshop.services

import bikeshop.domain.authentication._

/* 
JSON web token (JWT) used as the authentication method.
Auth is responsible for validation of encrypted passwords provided via the login function
*/


trait Authentication[F[_]]  {
  def findUser(token:JwtToken):F[Option[UserID]]
  def newUser(username: UserName, password:Password):F[JwtToken]
  def login(username: UserName, password:Password):F[JwtToken]
  def logout(token:JwtToken, username:UserName):F[Unit]
}
