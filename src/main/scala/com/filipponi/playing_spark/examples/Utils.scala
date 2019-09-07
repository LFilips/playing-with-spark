package com.filipponi.playing_spark.examples

object Utils {

  def printThreadInfo(): Unit = {
    val thread = Thread.currentThread()
    println(s"{ThreadId: ${thread.getId} " +
      s"Name: ${thread.getName} " +
      s"Priority: ${thread.getPriority} " +
      s"ThreadGroup: ${thread.getThreadGroup} " +
      s"ContextClassLoader: ${thread.getContextClassLoader} " +
      s"State: ${thread.getState}}")
  }

  //simple functions for measuring stuff, not as good as jhm but sometimes can be enough
  def formatNS(ns: Long): String = {
    if (ns < 1000L) ns + "ns"
    else if (ns < 1000000L) (ns / 1000L) + "µs"
    else if (ns < 1000000000L) (ns / 1000000L) + "ms"
    else (ns / 1000000000L) + "s"
  }

  def timed[A](f: => A, description: String): A = {
    val start = System.nanoTime()
    val result = f
    val end = System.nanoTime()
    println(s"$description ${formatNS(end - start)}")
    result
  }

}
