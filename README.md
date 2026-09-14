# DesignPatternsJava

Runnable **Gang of Four (GoF)** design pattern examples in **Java 27**, plus a simple factory, dependency-injection sample, and JUnit 5 tests. Built with Maven and ready for [Cursor Cloud Agents](https://cursor.com/docs/cloud-agent/setup) via `.cursor/environment.json`.

## Requirements

- **JDK 27** (OpenJDK 27+)
- **Apache Maven 3.8+**

Preview features are enabled project-wide (`--enable-preview` in `pom.xml` and `.mvn/jvm.config`) for APIs such as `LazyConstant` ([JEP 531](https://openjdk.org/jeps/531)) used in some examples.

### Cloud Agent

```bash
./scripts/cloud-agent-install.sh   # mvn dependency:resolve
mvn test
```

## Build and test

```bash
mvn test
```

Run a single pattern’s tests:

```bash
mvn -q test -Dtest=com.threerive.patterns.state.VendingMachineTest
```

## Package layout

All examples live under `src/main/java/com/threerive/patterns/<name>/` with matching tests under `src/test/java/...`.

### Creational

| Pattern | Package | Entry types |
| --- | --- | --- |
| Abstract Factory | `abstractfactory` | `ThemeFactory`, `DarkThemeFactory`, `LightThemeFactory` |
| Builder | `builder` | `EmailMessage`, `EmailMessage.Builder` |
| Factory Method | `factorymethod` | `DocumentCreator`, `PdfDocumentCreator`, `HtmlDocumentCreator` |
| Prototype | `prototype` | `Resume`, `Prototype` |
| Singleton | `singleton` | `Singleton` (`LazyConstant`) |
| Simple Factory | `factory` | `NotificationFactory`, `NotificationType` |

### Structural

| Pattern | Package | Entry types |
| --- | --- | --- |
| Adapter | `adapter` | `LegacyPaymentAdapter`, `PaymentProcessor` |
| Bridge | `bridge` | `Circle`, `Renderer`, `VectorRenderer`, `RasterRenderer` |
| Composite | `composite` | `File`, `Directory`, `FileSystemNode` |
| Decorator | `decorator` | `Coffee`, `MilkDecorator`, `WhipDecorator` |
| Facade | `facade` | `HomeTheaterFacade` |
| Flyweight | `flyweight` | `GlyphFactory`, `Glyph` |
| Proxy | `proxy` | `LazyImageProxy`, `Image` |

### Behavioral

| Pattern | Package | Entry types |
| --- | --- | --- |
| Chain of Responsibility | `chain` | `SupportHandler`, `BillingSupportHandler`, `TechnicalSupportHandler` |
| Command | `command` | `Command`, `RemoteControl`, `LightOnCommand` |
| Interpreter | `interpreter` | `Expression`, `AddExpression`, `NumberExpression` |
| Iterator | `iterator` | `BookCollection`, `Book` |
| Mediator | `mediator` | `ChatRoom`, `ChatMediator`, `ChatUser` |
| Memento | `memento` | `Editor`, `EditorMemento` |
| Observer | `observer` | `StockTicker`, `StockObserver`, `PercentChangeAlert` |
| State | `state` | `VendingMachine`, `VendingState` |
| Strategy | `strategy` | `ShoppingCart`, `PricingStrategy` |
| Template Method | `templatemethod` | `DataMiner`, `CsvDataMiner` |
| Visitor | `visitor` | `Shape`, `ShapeVisitor`, `AreaVisitor` |

### Related (not GoF)

| Pattern | Package | Entry types |
| --- | --- | --- |
| Dependency Injection | `injection` | `OrderService`, `ApplicationContext` |

## Quick examples

**Observer**

```java
StockTicker ticker = new StockTicker();
ticker.subscribe(change -> System.out.println(change.newPrice()));
ticker.setPrice("ACME", 100.0);
ticker.setPrice("ACME", 110.0);
```

**Strategy**

```java
ShoppingCart cart = new ShoppingCart(new TenPercentOffPricing());
cart.addItem(100.0);
cart.total();
```

**Visitor**

```java
Shape circle = new Circle(2);
double area = circle.accept(new AreaVisitor());
```

**Builder**

```java
EmailMessage.builder().to("a@b.com").subject("Hi").body("...").build();
```

## Configuration

| File | Purpose |
| --- | --- |
| `pom.xml` | Java 27, JUnit 5, preview compiler/test flags |
| `.cursor/Dockerfile` | OpenJDK 27 + Maven for Cloud Agents |
| `.github/workflows/maven.yml` | CI `mvn test` on push/PR |

## License

Add a `LICENSE` file if you distribute this project.
