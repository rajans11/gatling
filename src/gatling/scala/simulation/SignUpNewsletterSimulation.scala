package simulation

import actions.FillForm
import config.Config._
import io.gatling.core.Predef._
import io.gatling.http.Predef._

import scala.util.Random

class SignUpNewsletterSimulation extends Simulation {

  val httpProtocol = http
    .baseURL(config.getString("baseUrl"))

  val feeder = Iterator.continually(Map(
      "title" -> Random.alphanumeric.take(2).mkString,
      "firstname" -> Random.alphanumeric.take(5).mkString,
      "lastname" -> Random.alphanumeric.take(5).mkString,
      "email" -> "RTBCCF001@gmail.com"
    ))

  val signUp = scenario("Sign Up").feed(feeder)
      .exec(FillForm())

  setUp(
    signUp.
      inject(
//      atOnceUsers(1),
//      atOnceUsers(10),
//      nothingFor(10),
      rampUsers(Integer.getInteger("users", 1)) over java.lang.Long.getLong("ramp", 0L),
//      constantUsersPerSec(1) during(20) randomized,
//      constantUsersPerSec(0) during (30),
//      rampUsersPerSec(30) to(10) during(20),
//      constantUsersPerSec(0) during(10),
//      rampUsersPerSec(10) to(1) during(10)
    )
  ).protocols(httpProtocol)
    .assertions(
      forAll.responseTime.max.lt(1000),
      global.successfulRequests.percent.gt(95)
    )
}

