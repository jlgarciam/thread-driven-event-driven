#!/bin/bash
echo "SPRING - SERVER SITE EVENTS" &
curl -s http://localhost:8081/spring/ssevent -w  " %{time_starttransfer}\n" &
wait