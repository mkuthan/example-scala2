package org.mkuthan.scala2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class JsonTest extends AnyFlatSpec with Matchers {

  "Person" should "be serialized into Json object using interface object" in {
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

  "Person" should "be serialized into Json object using interface syntax" in {
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

  "Some of Person" should "be serialized into Json object" in {
    val person = Person("any name", 33.3)
    // writer for Option is invariant, can't use Some
    val json = Json.toJson(Option.apply(person))

    json should be(
      Json.JObject(
        Map(
          "name" -> Json.JString("any name"),
          "weight" -> Json.JNumber(33.3)
        )
      )
    )
  }

  "None of Person" should "be serialized into Json Null" in {
    // writer for Option is invariant, can't use None
    val json = Json.toJson(Option.empty[Person])

    json should be(Json.JNull)
  }

  "Circle" should "be serialized into Json object" in {
    val circle = Shape.circle(10.5)
    val json = Json.toJson(circle)

    json should be(
      Json.JObject(
        Map("radius" -> Json.JNumber(10.5))
      )
    )
  }

  "Rectangle" should "be serialized into Json object" in {
    val rectangle = Shape.rectangle(2, 3)
    val json = Json.toJson(rectangle)

    json should be(
      Json.JObject(
        Map("a" -> Json.JNumber(2), "b" -> Json.JNumber(3))
      )
    )
  }
}
