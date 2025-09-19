package tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    protected Logger log = LoggerFactory.getLogger(this.getClass());
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        log.info("Base URI set to: {}", RestAssured.baseURI);
    }
}
