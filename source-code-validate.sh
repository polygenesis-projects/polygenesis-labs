#!/usr/bin/env bash

./mvnw license:check-file-header
./mvnw fmt:check
./mvnw checkstyle:check

