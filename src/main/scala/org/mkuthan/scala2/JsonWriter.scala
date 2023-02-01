package org.mkuthan.scala2

trait JsonWriter[A] {
  def write(value: A): Json
}

object JsonWriter {
  implicit val personWriter: JsonWriter[Person] = new JsonWriter[Person] {

    override def write(p: Person): Json =
      Json.JObject(
        Map(
          "name" -> Json.JString(p.name),
          "weight" -> Json.JNumber(p.weight)
        )
      )

  }
}
