package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PetApiTest extends BaseTest {

    @Test
    public void testGetPetById() {
        log.info("Starting test: GET /pet/1");

        //override the baseURI for PetStore
        Response res = given()
                .baseUri("https://petstore.swagger.io/v2")
                .when().get("/pet/1")
                .then()
                .statusCode(200).
                extract().response();

        String petName = res.jsonPath().getString("name");
        int petId = res.jsonPath().getInt("id");

        try {
            Assert.assertNotNull(petName, "Pet name should not be null");
            Assert.assertTrue(petId > 0, "Pet ID should be greater than 0");
        } catch(AssertionError e) {
            log.error("Test failed! Response: {}", res.asString());
            throw e;
        }
        log.info("Pet API test passed successfully!");
    }
}
