package org.mkuthan.scala2

sealed trait Shape

object Shape {
  final case class Circle private (radius: Double) extends Shape
  final case class Rectangle private (a: Double, b: Double) extends Shape

  def circle(radius: Double): Shape = Circle(radius)
  def rectangle(a: Double, b: Double): Shape = Rectangle(a, b)
}
