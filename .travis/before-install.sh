#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_50f149f527b5_key -iv $encrypted_50f149f527b5_iv -in .travis/codesigning.asc.enc -out .travis/codesigning.asc -d
    gpg --fast-import codesigning.asc
fi

