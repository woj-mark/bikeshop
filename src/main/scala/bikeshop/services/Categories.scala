package bikeshop.services

import bikeshop.domain.category._

import cats.effect._
import cats.syntax.all._


trait Categories[F[_]]{
    def getAll: F[List[Category]]
    def create(name: CategoryName): F[CategoryID]
}
