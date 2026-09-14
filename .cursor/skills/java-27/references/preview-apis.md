# Preview APIs (Java 27)

This repository enables preview project-wide for examples that need it.

## Configuration

- **Compiler:** `maven-compiler-plugin` → `<compilerArgs><arg>--enable-preview</arg></compilerArgs>`
- **Tests:** `maven-surefire-plugin` → `<argLine>--enable-preview</argLine>`
- **Maven JVM:** `.mvn/jvm.config` contains `--enable-preview`

Command line:

```bash
javac --release 27 --enable-preview ...
java --enable-preview ...
```

## LazyConstant (JEP 531)

Third preview in JDK 27. Use for lazy, thread-safe, effectively immutable values (for example singleton holders or composition-root beans).

```java
import java.lang.LazyConstant;

private static final LazyConstant<MyService> SERVICE =
    LazyConstant.of(MyService::new);

public static MyService get() {
  return SERVICE.get();
}
```

**Used in this repo:** `com.threerive.patterns.singleton.Singleton`, `com.threerive.patterns.injection.ApplicationContext`.

**Guidelines:**

- Store `LazyConstant` in `static final` fields when you want JVM optimizations after initialization.
- Do not use preview APIs in packages that are meant to compile on Java 21 only unless you gate them or split modules.
- When removing preview usage, drop `--enable-preview` only if nothing else in the project needs it.

## Other JDK 27 features (non-preview)

Prefer these for most pattern examples:

- Records and sealed classes
- Pattern matching for `switch` and `instanceof`
- `List.copyOf`, `Objects.requireNonNullElse`
- Text blocks and modern `switch` expressions

Check [JDK 27 release notes](https://openjdk.org/projects/jdk/27/) for JEPs targeted to 27.
