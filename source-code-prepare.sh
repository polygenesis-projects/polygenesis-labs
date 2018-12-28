#!/usr/bin/env bash

./mvnw license:update-file-header
./mvnw fmt:format
#./mvnw install -DskipTests=true -Dmaven.javadoc.skip=true -B -V



