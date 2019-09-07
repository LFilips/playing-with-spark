package com.filipponi.playing_spark.examples

import com.filipponi.playing_spark.examples.Utils.printThreadInfo
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object SimpleContext {

  def singleThreadLocal(args: Array[String]): Unit = {

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
    val inputData: RDD[Int] = sparkSession.sparkContext.parallelize(List.tabulate(1000)(x => x))

    printf("This should be run from the main thread")
    printThreadInfo()

    println("From now on spark task submission kicks in ...")
    inputData.foreach { num =>
      printThreadInfo()
      println(num)
    }

    sparkSession.stop()

  }

  def multiCoreLocal(args: Array[String]): Unit = {

    /**
      * With local[4] you can instruct spark to run locally with 4 cores, but why cores and not threads?
      */
    val sparkContext = new SparkContext(
      new SparkConf()
        .setMaster("local[4]")
        .setAppName("test")
        .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
    )

    val sparkSession = SparkSession.builder
      .config(sparkContext.getConf)
      .getOrCreate()

    //maybe i'll need to add the metrics in the configuration
    val inputData: RDD[Int] = sparkSession.sparkContext.parallelize(List.tabulate(1000)(x => x))

    printf("This should be run from the main thread")
    printThreadInfo()

    println("From now on spark task submission kicks in ...")
    inputData.foreach { num =>
      printThreadInfo()
      println(num)
    }

    sparkSession.stop()

  }


}
