#!/usr/bin/env bash
if [ "$TRAVIS_BRANCH" = 'master' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_57f48c943df0_key -iv $encrypted_57f48c943df0_iv -in cd/codesigning.asc.enc -out cd/signingkey.asc -d
    gpg --fast-import cd/signingkey.asc
fi

if [ "$TRAVIS_BRANCH" = 'dev' ] && [ "$TRAVIS_PULL_REQUEST" == 'false' ]; then
    openssl aes-256-cbc -K $encrypted_57f48c943df0_key -iv $encrypted_57f48c943df0_iv -in cd/codesigning.asc.enc -out cd/signingkey.asc -d
    gpg --fast-import cd/signingkey.asc
fi
