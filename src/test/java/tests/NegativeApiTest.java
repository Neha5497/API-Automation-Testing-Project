package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NegativeApiTest extends BaseTest {

    @Test
    public void testInvalidEndpoint() {
        log.info("Starting test: GET /invalid");
        given()
                .when()
                .get("/invalid")
                .then()
                .statusCode(404);

        log.info("Invalid endpoint returned 404 as expected.");
    }
}
