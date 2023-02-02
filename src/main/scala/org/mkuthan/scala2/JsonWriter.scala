package org.mkuthan.scala2

trait JsonWriter[A] {
  def write(value: A): Json
}

object JsonWriter {
  implicit val personWriter: JsonWriter[Person] =
    new JsonWriter[Person] {
      override def write(value: Person): Json =
        Json.JObject(
          Map(
            "name" -> Json.JString(value.name),
            "weight" -> Json.JNumber(value.weight)
          )
        )

    }

  // type class composition
  implicit def optionWriter[A](implicit writer: JsonWriter[A]): JsonWriter[Option[A]] =
    new JsonWriter[Option[A]] {
      override def write(value: Option[A]): Json = value match {
        case Some(v) => writer.write(v)
        case None    => Json.JNull
      }
    }

  implicit val shapeWriter: JsonWriter[Shape] =
    new JsonWriter[Shape] {
      override def write(value: Shape): Json = value match {
        case c: Shape.Circle =>
          Json.JObject(
            Map("radius" -> Json.JNumber(c.radius))
          )
        case r: Shape.Rectangle =>
          Json.JObject(
            Map("a" -> Json.JNumber(r.a), "b" -> Json.JNumber(r.b))
          )
      }
    }
}
