# PolyGenesis Labs

[![Javadocs](http://javadoc.io/badge/io.polygenesis/polygenesis-labs.svg?color=brightgreen)](http://javadoc.io/doc/io.polygenesis/polygenesis-labs)
[![Build Status](https://travis-ci.com/polygenesis-io/polygenesis-labs.svg?branch=master)](https://travis-ci.org/polygenesis-io/polygenesis-labs)
[![Maven](https://img.shields.io/maven-central/v/io.polygenesis/polygenesis-labs.svg?label=Maven)](https://search.maven.org/search?q=g:%22io.polygenesis%22%20AND%20a:%22polygenesis-labs%22)
[![Quality Gate](https://sonarcloud.io/api/project_badges/measure?project=polygenesis-io_polygenesis-labs&metric=alert_status)](https://sonarcloud.io/dashboard?id=polygenesis-io_polygenesis-labs)

Playground for PolyGenesis development.


## SONAR
./mvnw sonar:sonar \
  -Dsonar.projectKey=polygenesis-io_polygenesis-labs \
  -Dsonar.organization=polygenesis-io \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=c91606530bb313e3953a064ccbe12504b95f9714


./mvnw sonar:sonar -Dsonar.projectKey=polygenesis-io_polygenesis-labs -Dsonar.organization=polygenesis-io -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=c91606530bb313e3953a064ccbe12504b95f9714

./mvnw clean org.jacoco:jacoco-maven-plugin:prepare-agent install sonar:sonar -Dsonar.projectKey=polygenesis-io_polygenesis-labs -Dsonar.organization=polygenesis-io -Dsonar.host.url=https://sonarcloud.io -Dsonar.login=c91606530bb313e3953a064ccbe12504b95f9714


    gpg --gen-key
    
    Christos Tsakostas
    ct@oregor.com
    MySuperPassPhrase1973
    
    GPG_KEYNAME
    33E368EDC117B2C16F431474B34681B1FA2F390D
    
    GPG_PASSPHRASE
    MySuperPassPhrase1973
    
    
    ----------------------------------
    OREGOR LTD
    ct@oregor.com
    Default Signing Key for OREGOR LTD
    MySuperPassPhrase1973
    
    
    mysuperpassphrase!
    
    '/Users/tsakostas/.gnupg/openpgp-revocs.d/F59C612769C1C44D0D451E0529C3DAE96A1D2AA6.rev'
    
    F59C612769C1C44D0D451E0529C3DAE96A1D2AA6
    
    
    gpg2 --keyserver hkp://pool.sks-keyservers.net --send-keys F59C612769C1C44D0D451E0529C3DAE96A1D2AA6
    29C3DAE96A1D2AA6
    
    
    
    gpg --send-keys --keyserver keyserver.ubuntu.com 29C3DAE96A1D2AA6
    gpg --send-keys --keyserver pgp.mit.edu 29C3DAE96A1D2AA6
    gpg --send-keys --keyserver pool.sks-keyservers.net 29C3DAE96A1D2AA6
    
    
    gpg --keyserver hkp://pool.sks-keyservers.net --recv-keys 29C3DAE96A1D2AA6
    gpg2 --keyserver hkp://pool.sks-keyservers.net --recv-keys 29C3DAE96A1D2AA6

    
    
    
    gpg --export --armor ct@oregor.com > codesigning.asc
    gpg --export-secret-keys --armor ct@oregor.com >> codesigning.asc
    
    
    
    
    
# https://medium.com/google-developers/how-to-run-travisci-locally-on-docker-822fc6b2db2e
    
    
    
    
    docker run --name travis-debug -dit travisci/ci-jvm:packer-1491942563 /sbin/init
    docker exec -it travis-debug bash -l
    su - travis
    
    cd builds
    git clone https://github.com/travis-ci/travis-build.git
    cd travis-build
    gem install travis
    travis # to create ~/.travis
    ln -s `pwd` ~/.travis/travis-build
    bundle install
    
    

    # Create ssh key for Github
    ssh-keygen -t rsa -b 4096 -C “ct@polygenesis.io”
    # Click enter to use default location for key
    # You can choose empty passphrase by clicking enter twice
    # Now that we have the key, let’s share with Github
    less ~/.ssh/id_rsa.pub
    # Copy the contents of the id_rsa.pub


    
    # Create project dir, assuming your project is `polygenesis-io/PROJECT` on GitHub
    cd ~/builds
    mkdir polygenesis-io
    cd polygenesis-io
    git clone --depth 1 https://github.com/polygenesis-io/polygenesis-labs.git
    git clone git@github.com:polygenesis-io/polygenesis-labs.git
    cd polygenesis-labs

    # change to the branch or commit you want to investigate
    # compile travis script into bash script
    travis compile > ci.sh
    
    # Go to bash script and fix the branch name
    vi ci.sh
    
    # in Vi type “/branch” to search and add the right branch name
    # — branch\=\’\NEW_BRANCH’\
    # You most likely will need to edit ci.sh as it ignores ‘matrix’ and ‘env’ keywords
    bash ci.sh


    
    
    
    
    
    
    
    
    
    
    
    
    ./mvnw install -DskipTests=true -Dmaven.javadoc.skip=true -B -V
    
    
    
    
    
    gpg --export --armor ct@polygenesis.io > codesigning.asc
    gpg --export-secret-keys --armor ct@polygenesis.io >> codesigning.asc
    travis encrypt-file codesigning.asc
    
    
    