package bikeshop.services

import bikeshop.domain.company._

import cats.effect._
import cats.syntax.all._

/*
Algebra for getting all companies and creating new ones
*/


trait Companies[F[_]]{
    def getAll: F[List[Company]]
    def create(name: CompanyName): F[CompanyID]
}
