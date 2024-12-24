# TestNG Lifecycle Annotations

TestNG offers a series of annotations that control **when** setup and teardown methods execute in relation to test methods. Below is an overview of these annotations and their typical usage in REST Assured or any other testing scenarios.

---

## 1.1 `@BeforeSuite`
- **When It Runs**: Once, *before the entire test suite* runs.
- **Purpose**:
    - Global setup for all tests in the suite.
    - Commonly used for configuring **REST Assured defaults** (e.g., `RestAssured.baseURI`), preparing **global data**, or **initializing dependencies** (e.g., database connections, external services, etc.).

---

## 1.2 `@BeforeTest`
- **When It Runs**: *Before each `<test>`* in your `testng.xml`.
- **Purpose**:
    - Scope is narrower than `@BeforeSuite` but can still cover multiple classes *if* they are grouped under the same `<test>` in `testng.xml`.
    - Less common if you only have a single `<test>` tag in your suite file.

---

## 1.3 `@BeforeClass`
- **When It Runs**: Once *per test class*, before any `@Test` methods in that class.
- **Purpose**:
    - Set up **data** or **state** needed by **all tests in the current class**.
    - Example: Configure a common **RequestSpecification** for REST Assured and store it in a static field.

---

## 1.4 `@BeforeMethod`
- **When It Runs**: *Before each* `@Test` method in the current class.
- **Purpose**:
    - Ensure a **clean state** before every individual test.
    - Example: Reset REST Assured configs, clear mock data, or log in to a service.
    - Guarantees isolation so that one test’s changes don’t affect another.

---

## 1.5 `@Test`
- **When It Runs**: The actual test method—each `@Test` is a standalone unit.
- **Purpose**:
    - Contains the logic to **send requests** (e.g., via REST Assured) and **assert the response**.
    - Focus on the core behavior you want to validate.

---

## 1.6 `@AfterMethod`
- **When It Runs**: *After each* `@Test` method in the current class.
- **Purpose**:
    - **Cleanup or teardown** per-test logic (e.g., remove test data created by that test, reset configurations).
    - Ensures each test starts fresh (pairs well with `@BeforeMethod`).

---

## 1.7 `@AfterClass`
- **When It Runs**: Once *per test class*, *after all* `@Test` methods in that class have executed.
- **Purpose**:
    - Cleanup tasks that apply to the entire class.
    - Common use cases:
        - Close database connections.
        - Reset or revert **global** variables/configuration changed during tests.
        - Remove class-level test data or mock servers.

---

## 1.8 `@AfterTest` / `@AfterSuite`
- **When They Run**: Similar in timing to `@BeforeTest` and `@BeforeSuite`, but for **teardown** at the `<test>` or **suite** level.
- **Purpose**:
    - **Final cleanup** after all tests in a given `<test>` (`@AfterTest`) or **the entire suite** (`@AfterSuite`).
    - For example:
        - Shutting down any external services started in `@BeforeSuite`.
        - Archiving logs or reports.
        - Releasing large-scale test resources.

---

## How They Fit into REST Assured

While **REST Assured** itself does not define these annotations, you use them (from TestNG) to structure how you:

1. **Configure** REST Assured (e.g., `RestAssured.baseURI`, `requestSpecification`).
2. **Set up or tear down** test data or mock services before/after tests.
3. **Reset** any persistent states to ensure each test is isolated.

Typically:
- `@BeforeSuite` or `@BeforeClass` sets **global** configurations (like `baseURI`).
- `@BeforeMethod` or `@AfterMethod` deals with per-test specifics (resetting or cleaning data).
- `@AfterClass` or `@AfterSuite` reverts global changes or frees resources.

By organizing your test code with these annotations, you keep your tests **maintainable, predictable,** and **scalable**.
