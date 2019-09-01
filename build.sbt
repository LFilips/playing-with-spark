name := "playing-with-spark"

version := "0.1"

scalaVersion := "2.11.12"

val sparkVersion = "2.4.3"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
  "org.apache.spark" %% "spark-sql" % sparkVersion % Provided,
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.holdenkarau" %% "spark-testing-base" % s"${sparkVersion}_0.12.0" % Test)