package org.mkuthan.scala2

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class CodecTest extends AnyFlatSpec with Matchers {

  "Codec" should "encode string" in {
    Codec.encode("10") should be("10")
  }

  "Codec" should "decode string" in {
    Codec.decode[String]("10") should be("10")
  }

  "Codec" should "encode int" in {
    Codec.encode(10) should be("10")
  }

  "Codec" should "decode int" in {
    Codec.decode[Int]("10") should be(10)
  }

  "Codec" should "encode boolean" in {
    Codec.encode(true) should be("true")
  }

  "Codec" should "decode boolean" in {
    Codec.decode[Boolean]("true") should be(true)
  }

  "Codec" should "encode Box" in {
    Codec.encode(Box("foo")) should be("foo")
  }

  "Codec" should "decode Box" in {
    Codec.decode[Box[String]]("foo") should be(Box("foo"))
  }
}
