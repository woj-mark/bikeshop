package bikeshop.services

import bikeshop.domain.healthstatus._

trait HealthStatus[F[_]] {
  def status:F[BackendStatus]
}
