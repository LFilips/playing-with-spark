#!/bin/bash

. "/spark/sbin/spark-config.sh"
. "/spark/bin/load-spark-env.sh"

mkdir -p $SPARK_WORKER_LOG

export SPARK_HOME=/spark

ln -sf /dev/stdout $SPARK_WORKER_LOG/spark-worker.out

/spark/sbin/../bin/spark-class org.apache.spark.deploy.worker.Worker --webui-port $SPARK_WORKER_WEBUI_PORT $SPARK_MASTER >> $SPARK_WORKER_LOG/spark-worker.out --cores 2
# Even if the docs says that when you register a spark worker it will register it using all the available cores
#i could just see 1 core register for every worker that lead to have 1 executor for each one. Maybe this is happening
#because i'm on docker and i only have logical core. Using the --cores flag you can force to have more and will appear
#in the UI. Having two workers that will run more that one executor in the same time is more similar to a real work
#scenario.
