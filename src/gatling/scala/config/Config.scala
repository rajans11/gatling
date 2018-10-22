package config

import com.typesafe.config.ConfigFactory

object Config {
  val config = ConfigFactory.load("gatling").getConfig("gatling.test")
}
