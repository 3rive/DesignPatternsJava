---
name: java-27
description: Build, test, and develop with Java 27 (OpenJDK 27), including preview features, Maven release 27, CI setup, and JDK installation. Use when the user or repository targets Java 27, javac reports "release version 27 not supported", or code uses LazyConstant and other JDK 27 previews.
---
# Java 27

Use this skill when working on Java 27 codebases, upgrading toolchains to 27, or fixing builds that require `--release 27`.

## When to use

- Compiling or running with `maven.compiler.release` 27
- Preview APIs (for example `java.lang.LazyConstant`, JEP 531)
- Cloud Agent / Docker images that must ship JDK 27
- GitHub Actions or local `JAVA_HOME` mismatches (JDK 17/21 vs project 27)

## Quick checks

```bash
java -version          # must report version 27
echo "$JAVA_HOME"
mvn -version           # Java version line should show 27
mvn -B test
```

If Maven uses the wrong JDK, set `JAVA_HOME` to the JDK 27 install before `mvn`.

## Project defaults (DesignPatternsJava)

| Setting | Location |
| --- | --- |
| Release | `pom.xml` → `maven.compiler.release` = 27 |
| Preview (Maven JVM) | `.mvn/jvm.config` → `--enable-preview` |
| Preview (compile/test) | `maven-compiler-plugin` and `maven-surefire-plugin` in `pom.xml` |
| CI JDK | `.github/workflows/maven.yml` → `java-version: '27'` |
| Agent image | `.cursor/Dockerfile` → `/opt/jdk-27` |

## Workflows

| Task | Reference |
| --- | --- |
| Install JDK 27 locally or in Docker | [Toolchain and CI](references/toolchain-and-ci.md) |
| Preview features and LazyConstant | [Preview APIs](references/preview-apis.md) |
| Add or change design pattern examples in this repo | [DesignPatternsJava repo](references/designpatterns-repo.md) |

## Rules

- Do not set `--release 27` unless the **compiler** is JDK 27; older JDKs fail with `release version 27 not supported`.
- Keep `--enable-preview` in sync across compiler, Surefire, and runtime when using preview APIs.
- Prefer records, sealed types, and `switch` expressions for examples; use preview APIs only when they illustrate the requested feature.
- Look up current JEP status on [openjdk.org](https://openjdk.org/jeps/0) before relying on preview behavior across JDK versions.

## Troubleshooting

| Symptom | Likely fix |
| --- | --- |
| `release version 27 not supported` | Install JDK 27; set `JAVA_HOME`; align CI `setup-java` to 27 |
| Preview API not found | Add `--enable-preview` to compiler and Surefire; run with JDK 27 |
| Tests pass locally, fail in CI | CI job JDK version lower than 27 |
