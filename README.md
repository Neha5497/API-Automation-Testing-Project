# API Automation Testing Project

A Java-based API automation testing framework using RestAssured, TestNG, and Maven.

## Project Overview

This project provides a robust framework for automated API testing with comprehensive test reporting and easy maintenance. Built with industry-standard tools and best practices for reliable API validation.

## Tech Stack

- **Java** - Programming language
- **Maven** - Build and dependency management
- **RestAssured** - API testing library
- **TestNG** - Testing framework
- **JSON** - Data handling and assertions
- **SLF4J** - Logging framework

## Project Structure

```
API-Automation-Testing-Project/
├── src/
│   └── test/
│       └── java/
│           └── tests/
├── target/
├── pom.xml
├── testng.xml
└── README.md
```

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone [repository-url]
   cd API-Automation-Testing-Project
   ```

2. **Install dependencies**
   ```bash
   mvn clean install
   ```

3. **Verify setup**
   ```bash
   mvn test
   ```

## Running Tests

### Run all tests
```bash
mvn test
```

### Run specific test suite
```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run tests with TestNG directly
```bash
java -cp "target/test-classes:target/dependency/*" org.testng.TestNG testng.xml
```

## Key Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| RestAssured | 5.5.0 | API testing and validation |
| TestNG | 7.4.0 | Test framework and reporting |
| JSON | 20230227 | JSON parsing and assertions |
| SLF4J | 2.0.16 | Logging |

## Test Configuration

The project uses `testng.xml` for test configuration:
- Test suite: "API Test Suite"
- Package: `tests`
- Configurable test parameters and groups

## Features

- ✅ RESTful API testing
- ✅ JSON response validation
- ✅ Comprehensive logging
- ✅ TestNG reporting
- ✅ Maven integration
- ✅ Configurable test suites

## Best Practices

- Follow Page Object Model pattern for test organization
- Use data providers for parameterized testing
- Implement proper error handling and logging
- Maintain separate configuration files for different environments
- Use meaningful test names and descriptions

## Author

**Neha Shende**

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Submit a pull request

## License

This project is licensed under the MIT License.