# playing-with-spark

This project has inside the docker commands for running locally a spark cluster (standalone) using 3 
docker containers, 1 for the master and two for the workers. Every worker register two cores so there will 
be 4 executors available to run tasks.

The path used in docker volume need to have permission to be used by docker, /Users is by default allowed
so i'm using ~.
 `~/mnt/trying-spark/spark-apps:/opt/spark-apps`

# Build

`./build-images`
then
`docker-compose up -d`
then you can connect with the ips that we have assigned in the docker-compose.

You can see the network with:
`docker network list`
and inspect it:
`docker network inspect`


Ip list:

Master:   10.5.0.2 http://10.5.0.2:8080/
Worker-1: 10.5.0.3 http://10.5.0.3:8081/
Worker-2: 10.5.0.4 http://10.5.0.4:8081/
Worker-3: 10.5.0.5 http://10.5.0.5:8081/

The connection to direct ips is not working for now, it is something due to osx and bridged network.
But the spark master UI at localhost:8080 can be seen (localhost:8081 will be available but one of
the executor will be picked randomly?)