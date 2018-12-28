#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ]; then
    ./mvnw deploy -P release --settings ./.m2/settings.xml
fi
