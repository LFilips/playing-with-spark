package com.filipponi.playing_spark.examples

object Utils {

  def printThreadInfo(): Unit = {
    val thread = Thread.currentThread()
    println(s"ThreadId: ${thread.getId} Name: ${thread.getName} Priority: ${thread.getName}")
  }

}
