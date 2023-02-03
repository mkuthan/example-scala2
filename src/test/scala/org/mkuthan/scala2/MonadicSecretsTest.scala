package org.mkuthan.scala2

import cats.Id
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MonadicSecretsTest extends AnyFlatSpec with Matchers {

  import MonadicSecrets._

  "Pure" should "lift value into applicative functor" in {
    pure(123) should be(Id(123))
  }

  "Map" should "act as covariant functor" in {
    map(123)(_ * 2) should be(Id(246))
  }

  "Flat map" should "map even if pure" in {
    flatMap(123)(_ * 2) should be(Id(246))
  }
}
