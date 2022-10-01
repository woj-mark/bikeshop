package bikeshop.services

import bikeshop.domain.category._

import cats.effect._
import cats.syntax.all._


/*
Algebra for getting all categories and creating new ones
*/

trait Categories[F[_]]{
    def getAll: F[List[Category]]
    def create(name: CategoryName): F[CategoryID]
}
