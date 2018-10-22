package actions

import io.gatling.http.Predef._
import io.gatling.core.Predef._

object FillForm {

  def apply() = {
    http("Some name")
      .post("/api/v2/permissions")
      .body(ElFileBody("signUpForm.json"))
      .check(status.is(201))
  }
}