package bikeshop.domain

import java.util.UUID


object company{

case class CompanyID(value: UUID)
case class CompanyName(value: String)

case class Company(id:CompanyID, name: CompanyName)
}