package org.mkuthan.scala2

sealed trait Json

object Json {
  final case class JObject(get: Map[String, Json]) extends Json
  final case class JString(get: String) extends Json
  final case class JNumber(get: Double) extends Json
  final case object JNull extends Json

  def toJson[A](value: A)(implicit w: JsonWriter[A]): Json = w.write(value)
}
