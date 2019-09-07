package com.filipponi.playing_spark.examples

import com.filipponi.playing_spark.examples.SimpleContext.{multiCoreLocal, singleThreadLocal}
import com.filipponi.playing_spark.examples.Utils.timed
import org.scalatest.FlatSpec

class SimpleContextTest extends FlatSpec {

  behavior of "SimpleContext"

  it should "run the singleThreadLocal example" in {

    timed(singleThreadLocal(args = Array[String]("Nothing")),"singleThreadLocal")

  }

  it should "run the multiCoreLocal example" in {

    timed(multiCoreLocal(args = Array[String]("Nothing")),"multicoreLocal")

  }

}
