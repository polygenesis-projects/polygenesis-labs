#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ]; then
    openssl aes-256-cbc -K $encrypted_50f149f527b5_key -iv $encrypted_50f149f527b5_iv -in codesigning.asc.enc -out codesigning.asc -d
    gpg --fast-import codesigning.asc
fi

