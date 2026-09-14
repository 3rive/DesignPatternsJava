FROM ubuntu:24.04

ARG JDK_27_URL=https://download.java.net/java/GA/jdk27/55ce5470a6294008af0057ff4626d0e5/35/GPL/openjdk-27_linux-x64_bin.tar.gz

RUN apt-get update \
    && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
        ca-certificates \
        curl \
        git \
        maven \
    && mkdir -p /opt/jdk-27 \
    && curl -fsSL "${JDK_27_URL}" \
        | tar -xzf - -C /opt/jdk-27 --strip-components=1 \
    && rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/opt/jdk-27
ENV PATH="${JAVA_HOME}/bin:${PATH}"

USER ubuntu
