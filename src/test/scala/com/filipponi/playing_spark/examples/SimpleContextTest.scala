package com.filipponi.playing_spark.examples

import org.scalatest.FlatSpec

class SimpleContextTest extends FlatSpec {

  behavior of "SimpleContextTest"

  it should "run" in {

    SimpleContext.run(args = Array[String]("Nothing"))

  }

}
