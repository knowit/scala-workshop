package example.repository

import example.models.Setting

class CustomerSettingsRepository {

  var customerSettings: Map[String, List[Setting]] = Map.empty

  def addSetting(customerId: String, setting: Setting) = ???

}
