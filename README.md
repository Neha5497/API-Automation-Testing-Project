REST API Automation Framework using Java, TestNG, RestAssured & SLF4J

Project Description:
This is a fully automated API testing project for multiple public APIs, including Users, Posts, Orders, and Pets. The framework is designed using Java 8, TestNG, RestAssured, and SLF4J logging, focusing on:
  •Positive and negative test scenarios
  •Data-driven testing with TestNG @DataProvider
  •Handling auto-generated IDs
  •Large payload testing
  •Detailed logging for debugging
This project is interview-ready and scalable for adding more APIs in the future.

Features:
1.Data-Driven Testing
  •Tests multiple users, posts, and orders using TestNG @DataProvider.
  •Reduces code duplication and increases test coverage.

2.Logging
  •Uses SLF4J to log each test step, request, and response.
  •Prints detailed error messages for easier debugging.

3.Robust ID Handling
  •Auto-generated IDs from APIs are validated without assuming fixed values.

4.Large Payload Testing
  •Ensures APIs can handle large JSON bodies without failure.

5.Negative Testing
  •Validates invalid endpoints return proper 404 errors.

6.Java 8 Compatibility
  •All tests run on Java 8, ensuring enterprise-level compatibility.

7.TestNG Suite Execution
  •Single testng.xml file to run all test cases together.

Project Structure
src
 └─ main/java
 └─ tests
      ├─ BaseTest.java           # Common setup & logging
      ├─ UserApiTest.java        # Users API tests (DataProvider)
      ├─ PostApiTest.java        # Posts API tests (DataProvider + large payloads)
      ├─ PetApiTest.java         # Pets API tests
      ├─ OrderApiTest.java       # Orders API tests (DataProvider)
      └─ NegativeApiTest.java    # Negative test cases (invalid endpoints)
testng.xml                      # TestNG suite configuration
pom.xml                          # Maven dependencies (RestAssured, TestNG, SLF4J)

Execution Flow:
  1.BaseTest.java initializes RestAssured base URI and logging.
  2.UserApiTest.java runs GET /users/{id} for multiple users using DataProvider.
  3.PostApiTest.java runs POST /posts for multiple payloads, including large body testing, validating title, body, userId, and auto-generated ID.
  4.PetApiTest.java tests GET /pet/{id} and validates pet details.
  5.OrderApiTest.java runs POST /store/order for multiple scenarios using DataProvider.
  6.NegativeApiTest.java validates invalid endpoints return 404.
  7.Logs all test steps, errors, and responses using SLF4J.

Key Highlights:
  •Data-driven tests for scalability
  •Proper handling of auto-generated IDs
  •Comprehensive logging for debugging
  •Java 8 compatible
  •Fully automated and ready for CI/CD integration

Dependencies
  •Java 8
  •Maven
  •TestNG
  •RestAssured
  •SLF4J

pom.xml snippet:

<dependencies>
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>4.5.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.10.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-simple</artifactId>
        <version>2.0.7</version>
    </dependency>
</dependencies>

Future Enhancements:
  •Add HTML reporting using ExtentReports
  •Integrate with CI/CD pipelines (Jenkins/GitHub Actions)
  •Add more API endpoints and negative scenarios
  •Implement environment-based configurations for staging/production

Author:
Neha Shende

Email: <your-email>

LinkedIn: <your-linkedin>
