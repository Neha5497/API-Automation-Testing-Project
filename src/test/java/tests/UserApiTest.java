package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class UserApiTest extends BaseTest {

        @DataProvider(name = "userIds")
        public Object[][] provideUserIds() {
            return new Object[][] {
                    {1, "Leanne Graham"},
                    {2, "Ervin Howell"},
                    {3, "Clementine Bauch"},
                    {4, "Patricia Lebsack"},
                    {5, "Chelsey Dietrich"},
                    {6, "Mrs. Dennis Schulist"},
                    {7, "Kurtis Weissnat"},
                    {8, "Nicholas Runolfsdottir V"},
                    {9, "Glenna Reichert"},
                    {10, "Clementina DuBuque"}
            };
        }

        @Test(dataProvider = "userIds")
        public void testGetUserById(int userId, String expectedName) {

            log.info("Starting test: GET /users/{}", userId);

        Response res = given()
                .when().get("/users/" + userId)
                .then().statusCode(200).extract().response();

        String email = res.jsonPath().getString("email");
        String name = res.jsonPath().getString("name");

        try {
        Assert.assertTrue(email.matches("^[A-Za-z0-9+_.-]+@(.+)$"), "Invalid email format!");
        Assert.assertEquals(name, expectedName, "Name mismatch!");
    } catch(AssertionError e) {
            log.error("Test failed! Response: {}", res.asString());
            throw e;
        }
        log.info("User API test passed for userId: {}", userId);
    }
}
