package bikeshop.services

import bikeshop.domain.bike._
import bikeshop.domain.company._

import cats.effect._
import cats.syntax.all._

trait Bikes[F[_]] {
    def getAll: F[List[Bike]]
    def findBy(company: CompanyName): F[List[Bike]]
    def findBy(bikeID: BikeID): F[Option[Bike]]
    def create(bike: CreateBike) : F[BikeID]
    def update(bike: UpdateBike) : F[Unit]
}

