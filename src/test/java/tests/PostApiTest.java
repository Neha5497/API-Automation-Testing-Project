package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PostApiTest extends BaseTest{

    @DataProvider(name = "postData")
    public Object[][] providePosts() {
        return new Object[][]{
                {"My Post", "Automation testing", 1},
                {"Another Post", "Testing with multiple payloads", 2}
        };
    }

    @Test(dataProvider = "postData")
    public void testCreatePost(String title, String body, int userId) {
        log.info("Starting test: POST /posts with title={}", title);

        String requestBody = "{ \"title\": \"" + title + "\", \"body\": \"" + body + "\", \"userId\": " + userId + "}";


        Response res = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        String resTitle = res.jsonPath().getString("title");
        String resBody = res.jsonPath().getString("body");
        int resUserId = res.jsonPath().getInt("userId");
        int resId = res.jsonPath().getInt("id");


        try {
        Assert.assertEquals(resTitle, title, "Title mismatch!");
        Assert.assertEquals(resBody, body, "Body mismatch!");
        Assert.assertEquals(resUserId, userId, "User ID mismatch!");
        Assert.assertTrue(resId > 0, "ID should be auto-generated and greater than 0");
        } catch(AssertionError e) {
            log.error("Test failed! Response: {}", res.asString());
            throw e;
        }
        log.info("Post API test passed for user ID={}", userId);
    }
    @Test
    public void testLargePayloadPost() {
        log.info("Starting test: POST /posts with large payload");

        //Build long string for Java 8
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000; i++) {
            sb.append("A");
        }
        String longBody = sb.toString();

        String requestBody = "{ \"title\": \"Long Post\", \"body\": \"" + longBody + "\", \"userId\": 1 }";


        Response res = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract().response();

        String resId = res.jsonPath().getString("id");
        Assert.assertNotNull(resId, "Auto-generated ID should not be null");
        Assert.assertTrue(Integer.parseInt(resId) > 0, "ID should be > 0");


        log.info("Large payload POST API test passed successfully");
    }
}
