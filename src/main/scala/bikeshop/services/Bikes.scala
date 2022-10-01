package bikeshop.services

import bikeshop.domain.bike._
import bikeshop.domain.company._

import cats.effect._
import cats.syntax.all._


/*
Algebra for creatring and retrieving the bikes by company names or id.
Allowance for a POST and PUT endpoints to create and update the bikes.
*/

trait Bikes[F[_]] {
    def getAll: F[List[Bike]]
    def findBy(company: CompanyName): F[List[Bike]]
    def findBy(bikeID: BikeID): F[Option[Bike]]
    def create(bike: CreateBike) : F[BikeID]
    def update(bike: UpdateBike) : F[Unit]
}

