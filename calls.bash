#!/bin/bash
echo "NODE" &
curl -s http://localhost:8080/node/request -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8080/node/request -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8080/node/request -w  " %{time_starttransfer}\n" &
wait

echo "SPRING - REACTIVE" &
curl -s http://localhost:8081/spring/reactive -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8081/spring/reactive -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8081/spring/reactive -w  " %{time_starttransfer}\n" &

wait

echo "SPRING - MVC" &
curl -s http://localhost:8082/spring/rest -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8082/spring/rest -w  " %{time_starttransfer}\n" &
curl -s http://localhost:8082/spring/rest -w  " %{time_starttransfer}\n" &

wait