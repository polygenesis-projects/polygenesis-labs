#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    ./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent package sonar:sonar \
      -Dsonar.projectKey=polygenesis-projects_polygenesis-labs \
      -Dsonar.organization=polygenesis-projects \
      -Dsonar.host.url=https://sonarcloud.io \
      -Dsonar.login=096bd25eaf73bb3d0a32a3478dc9109d2de7c8eb
else
    ./mvnw test -B
fi

