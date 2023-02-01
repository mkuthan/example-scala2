package org.mkuthan.scala2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PersonTest extends AnyFlatSpec with Matchers {

  "Person" should "be serialized into Json using interface object" in {
    // no imports, JsonWriter is already in scope because it's Json.toJson parameter
    // quite convenient if there is only one matching writer

    val person = Person("any name", 33.3)
    val json = Json.toJson(person)

    json should be(
      Json.JObject(
        Map(
          "name" -> Json.JString("any name"),
          "weight" -> Json.JNumber(33.3)
        )
      )
    )
  }

  "Person" should "be serialized into Json using interface syntax" in {
    import JsonSyntax._

    val person = Person("any name", 22.1)
    val json = person.toJson

    json should be(
      Json.JObject(
        Map(
          "name" -> Json.JString("any name"),
          "weight" -> Json.JNumber(22.1)
        )
      )
    )
  }
}
