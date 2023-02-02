package org.mkuthan.scala2

sealed trait Shape

object Shape {
  final case class Circle(radius: Double) extends Shape
  final case class Rectangle(a: Double, b: Double) extends Shape
}
