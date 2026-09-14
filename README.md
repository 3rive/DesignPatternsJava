# DesignPatternsJava

Runnable examples of common design patterns in Java, with JUnit 5 tests and a Maven build. The project is set up for local development and [Cursor Cloud Agents](https://cursor.com/docs/cloud-agent/setup) via `.cursor/environment.json`.

## Requirements

- **JDK 27** (OpenJDK 27+ recommended)
- **Apache Maven 3.8+**

Preview features are enabled for examples that use Java 27 APIs (see below). Maven picks this up from `.mvn/jvm.config` and the compiler/surefire configuration in `pom.xml`.

### Cloud Agent image

The Dockerfile under `.cursor/` installs OpenJDK 27 and Maven. After checkout, run:

```bash
./scripts/cloud-agent-install.sh
```

That script resolves Maven dependencies when `pom.xml` is present.

## Build and test

```bash
mvn test
```

Other useful commands:

```bash
mvn -q -DskipTests package
mvn -q test -Dtest=com.threerive.patterns.observer.StockTickerTest
```

## Project layout

```
src/main/java/com/threerive/
├── HelloPatterns.java              # Minimal entry/smoke class
└── patterns/
    ├── singleton/                  # Java 27 (LazyConstant preview)
    ├── factory/                    # Simple factory
    ├── observer/                   # Observer (Java 21–compatible APIs)
    ├── injection/                  # Dependency injection + composition root
    └── builder/                    # Fluent builder for immutable products
```

## Pattern catalog

| Pattern | Package | Java | Summary |
| --- | --- | --- | --- |
| **Singleton** | `com.threerive.patterns.singleton` | 27 (preview) | One shared instance via `LazyConstant` ([JEP 531](https://openjdk.org/jeps/531)) |
| **Factory** | `com.threerive.patterns.factory` | 27 | `NotificationFactory` creates `EMAIL` / `SMS` `Notification` products by `NotificationType` |
| **Observer** | `com.threerive.patterns.observer` | 21+ | `StockTicker` notifies `StockObserver` implementations on price changes |
| **Dependency injection** | `com.threerive.patterns.injection` | 27 (preview) | Constructor-injected `OrderService`; `ApplicationContext` wires dependencies with `LazyConstant` |
| **Builder** | `com.threerive.patterns.builder` | 27 | Fluent `EmailMessage.Builder` constructs validated immutable `EmailMessage` instances |

### Singleton

- **Classes:** `Singleton`
- **Tests:** `SingletonTest` (same instance, concurrent `getInstance`)

```java
Singleton instance = Singleton.getInstance();
```

### Factory

- **Classes:** `Notification`, `NotificationType`, `NotificationFactory`, `EmailNotification`, `SmsNotification`
- **Tests:** `NotificationFactoryTest`

```java
Notification email = NotificationFactory.create(NotificationType.EMAIL);
String body = email.format("user@example.com", "Order shipped");
```

### Observer

- **Classes:** `StockTicker`, `StockObserver`, `StockPriceChange`, `PercentChangeAlert`
- **Tests:** `StockTickerTest`

Uses records and standard library types only (no preview flags required for this package).

```java
StockTicker ticker = new StockTicker();
ticker.subscribe(change -> System.out.println(change.symbol() + " -> " + change.newPrice()));
ticker.setPrice("ACME", 100.0);  // baseline
ticker.setPrice("ACME", 110.0);  // observers notified
```

### Builder

- **Classes:** `EmailMessage` (nested `Builder`)
- **Tests:** `EmailMessageTest`

```java
EmailMessage message =
    EmailMessage.builder()
        .to("user@example.com")
        .subject("Welcome")
        .body("Thanks for signing up.")
        .highPriority(true)
        .build();
```

### Dependency injection

- **Classes:** `OrderService`, `PaymentGateway`, `OrderRepository`, `ApplicationContext`, `ConsolePaymentGateway`, `InMemoryOrderRepository`
- **Tests:** `OrderServiceTest` (fakes + composition root smoke test)

```java
// Production-style wiring
CheckoutResult result = ApplicationContext.orderService().checkout("order-1", 1999);

// Test-style wiring
OrderService service = new OrderService(fakeGateway, repository, Clock.fixed(instant, ZoneOffset.UTC));
```

## Configuration files

| File | Purpose |
| --- | --- |
| `pom.xml` | Java 27 release, JUnit 5, preview-enabled compile/test |
| `.mvn/jvm.config` | `--enable-preview` for the Maven JVM |
| `.cursor/environment.json` | Cloud Agent environment name, Docker build, install script |
| `.cursor/Dockerfile` | Ubuntu 24.04 + OpenJDK 27 + Maven |
| `scripts/cloud-agent-install.sh` | Idempotent `mvn dependency:resolve` |

## License

See repository defaults; add a `LICENSE` file if you intend to distribute this project.
