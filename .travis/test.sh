#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ]; then
    ./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar
fi
if [ "$TRAVIS_BRANCH" != 'master' ]; then
    ./mvnw test -B
fi
