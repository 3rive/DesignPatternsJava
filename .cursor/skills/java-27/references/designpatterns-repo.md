# DesignPatternsJava repository

Conventions for adding or changing code in **DesignPatternsJava** on Java 27.

## Layout

```
src/main/java/com/threerive/patterns/<pattern>/
src/test/java/com/threerive/patterns/<pattern>/
```

- Package name: lowercase pattern id (`factorymethod`, `templatemethod`, `abstractfactory`).
- One GoF pattern per package; keep examples small (roughly 2–8 types).
- Add **one** JUnit 5 test class per package with at least two meaningful assertions.

## Existing packages

**Creational:** `abstractfactory`, `builder`, `factory`, `factorymethod`, `prototype`, `singleton`

**Structural:** `adapter`, `bridge`, `composite`, `decorator`, `facade`, `flyweight`, `proxy`

**Behavioral:** `chain`, `command`, `interpreter`, `iterator`, `mediator`, `memento`, `observer`, `state`, `strategy`, `templatemethod`, `visitor`

**Related:** `injection` (dependency injection / composition root, not GoF)

## Adding a new example

1. Create types under `src/main/java/com/threerive/patterns/<name>/`.
2. Add `*Test.java` under `src/test/java/...`.
3. Run `mvn test` with `JAVA_HOME` pointing at JDK 27.
4. Update root `README.md` pattern catalog table if the catalog changes.

## Style

- `final` classes where inheritance is not part of the pattern demo.
- Private constructors for singletons/builders as appropriate.
- Avoid external frameworks; plain Java + JUnit only.
- Match naming and test style of neighboring packages (for example `*Test`, AssertJ-style JUnit assertions).

## Do not

- Commit `target/` (listed in `.gitignore`).
- Lower `maven.compiler.release` without updating CI, Docker, and preview-dependent code.
- Add heavy dependencies to `pom.xml` for teaching examples.
