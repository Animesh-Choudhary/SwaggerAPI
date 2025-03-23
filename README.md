# API Test Framework

## Overview
This API Test Framework is built using Java, TestNG, and RestAssured. It provides a structured and reusable setup for API automation testing, incorporating logging, reporting, and configuration management.

## Project Structure
```
📦 api-test-framework
│── 📂 src
│   ├── 📂 main
│   │   ├── 📂 java
│   │   │   ├── 📂 base
│   │   │   │   ├── BaseTest.java  ← (Handles TestNG setup & teardown)
│   │   │   │   ├── BaseAPI.java  ← (Executes API requests using RestAssured)
│   │   │   ├── 📂 config
│   │   │   │   ├── ConfigManager.java  ← (Loads properties from config files)
│   │   │   ├── 📂 utils
│   │   │   │   ├── JSONUtils.java  ← (Manages JSON payloads dynamically)
│   │   │   │   ├── LoggerUtil.java  ← (Handles logging using SLF4J)
│   │   │   ├── 📂 listeners
│   │   │   │   ├── TestListener.java  ← (Implements TestNG listeners for execution tracking)
│   │   │   ├── 📂 reports
│   │   │   │   ├── AllureManager.java  ← (Generates Allure reports)
│   │   │   ├── 📂 api
│   │   │   │   ├── PetAPI.java  ← (Contains API methods for Pet endpoints)
│   │   │   │   ├── StoreAPI.java  ← (Contains API methods for Store endpoints)
│   │   │   │   ├── UserAPI.java  ← (Contains API methods for User endpoints)
│   ├── 📂 test
│   │   ├── 📂 java
│   │   │   ├── 📂 tests
│   │   │   │   ├── PetTests.java  ← (Contains test cases for Pet API)
│   │   │   │   ├── StoreTests.java  ← (Contains test cases for Store API)
│   │   │   │   ├── UserTests.java  ← (Contains test cases for User API)
│   ├── 📂 resources
│   │   ├── config.properties  ← (Holds environment configurations)
│   │   ├── testdata.json  ← (Stores test data for API payloads)
│── pom.xml  ← (Manages dependencies for TestNG, RestAssured, Allure, etc.)
```

## Setup Instructions
### Prerequisites
Ensure the following are installed:
- Java (JDK 1.8 or later)
- Maven
- An IDE (IntelliJ IDEA, Eclipse, etc.)

### Installation & Execution
1. Clone the repository:
   ```sh
   git clone <repository-url>
   cd api-test-framework
   ```
2. Install dependencies:
   ```sh
   mvn clean install
   ```
3. Run tests:
   ```sh
   mvn test
   ```
4. Generate Allure reports:
   ```sh
   mvn allure:report
   ```

## Maven Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.16.1</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.7.0</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.5.1</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>io.qameta.allure</groupId>
        <artifactId>allure-testng</artifactId>
        <version>2.23.0</version>
    </dependency>
</dependencies>
```

## Framework Components
### ConfigManager.java
- Loads environment settings (base URL, auth keys, timeouts) from `config.properties`.

### BaseAPI.java
- Executes API requests using RestAssured.
- Calls `JSONUtils.java` to fetch test payloads.

### JSONUtils.java
- Reads `testdata.json` and provides dynamic payloads for tests.

### LoggerUtil.java
- Implements structured logging with SLF4J.
- Logs request and response details.

### TestListener.java
- Hooks into TestNG’s lifecycle.
- Captures test failures and logs execution details.

### AllureManager.java
- Generates detailed reports after test execution.

### API Classes (PetAPI.java, StoreAPI.java, UserAPI.java)
- Contains methods for API endpoints.
- Called by test classes in `tests/` package.

### Test Classes (PetTests.java, StoreTests.java, UserTests.java)
- Implement test cases using TestNG.
- Call API methods from `PetAPI.java`, `StoreAPI.java`, `UserAPI.java`.

## Test Execution Flow
1. Test classes (`PetTests.java`, `StoreTests.java`, `UserTests.java`) call API methods.
2. API methods (`PetAPI.java`, etc.) call `BaseAPI.java` to send requests.
3. `BaseAPI.java` fetches configurations from `ConfigManager.java`.
4. `BaseAPI.java` calls `JSONUtils.java` to fetch test payloads.
5. Test execution tracked by `TestListener.java` and logged by `LoggerUtil.java`.
6. Reports are generated using `AllureManager.java`.

## Reporting
After executing tests, generate and view reports:
```sh
allure serve target/allure-results
```

## Contributions
Feel free to contribute by raising issues or submitting pull requests.

## License
This project is licensed under the MIT License.

