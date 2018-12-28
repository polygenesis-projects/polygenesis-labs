FROM travisci/ci-jvm:packer-1491942563
USER travis
RUN bash -lc "rvm install 2.3.0"
RUN bash -lc "rvm use 2.3.0 --default"
WORKDIR /home/travis/builds
RUN git clone https://github.com/travis-ci/travis-build.git
WORKDIR travis-build
RUN mkdir -p /home/travis/.travis
RUN ln -s $(pwd) /home/travis/.travis/travis-build
RUN bash -lc "bundle install"
RUN bash -lc "bundler add travis"
WORKDIR /home/travis/builds/travis-build

RUN bash -lc "bundler binstubs travis"

# Clone a random repo containing a .travis.yml
RUN git clone --depth 1 https://github.com/polygenesis-io/polygenesis-labs.git
WORKDIR polygenesis-labs
CMD ["bash", "-l", "-c", "/home/travis/.travis/travis-build/bin/travis compile --no-interactive"]