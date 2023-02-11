package org.mkuthan.scala2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ScaffoldingTest extends AnyFlatSpec with Matchers {

  import Scaffolding._

  "Scaffolding" should "map using fold right" in {
    val list = List(1, 2, 3)
    map(list)(_ * 2) should be(List(2, 4, 6))
  }

  "Scaffolding" should "flatMap using fold right" in {
    val list = List(1, 2, 3)
    flatMap(list)(elem => List(elem * 2, elem * 10)) should be(List(2, 10, 4, 20, 6, 30))
  }

  "Scaffolding" should "filter using fold right" in {
    val list = List(1, 2, 3)
    filter(list)(_ < 3) should be(List(1, 2))
  }

  "Scaffolding" should "sum using fold right" in {
    val list = List(1, 2, 3)
    sum(list) should be(6)
  }
}
