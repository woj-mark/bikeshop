
package bikeshop.domain

import java.util.UUID

object category{
case class CategoryID(value: UUID)
case class CategoryName(value: String)

case class Category(id:CategoryID, name: CategoryName)
}