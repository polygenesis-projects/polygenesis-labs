#!/usr/bin/env bash
./mvnw install -P validate-license,validate-code-format,validate-code-style,validate-code-bugs,validate-code \
 -DskipTests=true -Dmaven.javadoc.skip=true -B -V