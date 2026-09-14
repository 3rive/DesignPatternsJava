# Toolchain and CI (Java 27)

## Local and Cloud Agent

**Verify:**

```bash
java -version
javac -version
mvn -version
```

**Set JDK 27 for one shell:**

```bash
export JAVA_HOME=/opt/jdk-27   # or your install path
export PATH="$JAVA_HOME/bin:$PATH"
```

This repository’s Cloud Agent Dockerfile installs OpenJDK 27 under `/opt/jdk-27` and sets `JAVA_HOME` in the image.

## Install OpenJDK 27 (Linux x64)

Official GA builds (adjust URL if a newer build is required):

```bash
JDK_27_URL=https://download.java.net/java/GA/jdk27/55ce5470a6294008af0057ff4626d0e5/35/GPL/openjdk-27_linux-x64_bin.tar.gz
sudo mkdir -p /opt/jdk-27
curl -fsSL "$JDK_27_URL" | sudo tar -xzf - -C /opt/jdk-27 --strip-components=1
/opt/jdk-27/bin/java -version
```

## Maven

Standard build for this repo:

```bash
mvn -B test
mvn -B -q -DskipTests package
```

Single test class:

```bash
mvn -q test -Dtest=com.threerive.patterns.state.VendingMachineTest
```

## GitHub Actions

Use JDK 27 on the runner so it matches `pom.xml`:

```yaml
- uses: actions/setup-java@v4
  with:
    java-version: '27'
    distribution: 'temurin'
    cache: maven
- run: mvn -B test
```

If Temurin 27 is unavailable on the runner, install from [jdk.java.net](https://jdk.java.net/27/) in a workflow step and set `JAVA_HOME` before `mvn`.

## Bootstrap in this repo

```bash
./scripts/cloud-agent-install.sh
```

Runs `mvn dependency:resolve` when `pom.xml` exists.
