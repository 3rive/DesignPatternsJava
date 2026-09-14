FROM ubuntu:24.04

RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        ca-certificates \
        curl \
        git \
        maven \
        openjdk-21-jdk-headless \
    && rm -rf /var/lib/apt/lists/*

USER ubuntu
