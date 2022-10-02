package bikeshop.services

import bikeshop.domain.healthstatus._

trait Healthstatus[F[_]] {
  def status:F[BackendStatus]
}
