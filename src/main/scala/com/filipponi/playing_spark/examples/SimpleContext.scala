package com.filipponi.playing_spark.examples

import com.filipponi.playing_spark.examples.Utils.printThreadInfo
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SimpleContext {

  def run(args: Array[String]): Unit = {

    /**
      * This will create a simple local context.
      */
    val sparkContext = new SparkContext(
        new SparkConf()
          .setMaster("local")
          .setAppName("test")
          .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      )

    val sparkSession = SparkSession.builder
      .config(sparkContext.getConf)
      .getOrCreate()

    //maybe i'll need to add the metrics in the configuration
    val inputData: RDD[Int] = sparkSession.sparkContext.parallelize(List(1,2,3,4,5))

    inputData.foreach { num =>
      printThreadInfo()
      println(num)
    }

    sparkSession.stop()

  }


}
