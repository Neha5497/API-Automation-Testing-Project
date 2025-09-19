package tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class OrderApiTest extends BaseTest{

    @DataProvider(name = "orderData")
    public Object[][] provideOrders() {
        return new Object[][] {
            { 1, 1, 1, "placed", true },
            { 2, 2, 3, "approved", false },
            { 3, 3, 4, "delivered", true },
            { 4, 4, 5, "placed", true },
            { 5, 5, 6, "approved", false },
            { 6, 6, 7, "delivered", true },
            { 7, 7, 8, "placed", true },
            { 8, 8, 9, "approved", false },
            { 9, 9, 10, "delivered", true },
            { 10, 10, 11, "placed", true }
        };
    }

    @Test(dataProvider = "orderData")
    public void testPlaceOrder(int orderId, int petId, int quantity, String status, boolean complete) {
        log.info("Starting test: POST /store/order with id={}", orderId);

        String requestBody = "{\"id\": " + orderId + ", \"petId\": " + petId + ", \"quantity\": " + quantity + ", " +
                "\"status\": \"" + status + "\", \"complete\": " + complete + "}";

        Response res = given()
                .baseUri("https://petstore.swagger.io/v2")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract().response();

        int resId = res.jsonPath().getInt("id");
        String resStatus = res.jsonPath().getString("status");
        boolean resComplete = res.jsonPath().getBoolean("complete");

        try {
            Assert.assertTrue(resId > 0, "Order ID should be greater than 0");
            Assert.assertEquals(resStatus, status, "Order status mismatch");
            Assert.assertEquals(resComplete, complete, "Order completion mismatch");
        } catch(AssertionError e) {
            log.error("Test failed! Response: {}", res.asString());
            throw e;
        }
        log.info("Order API test passed successfully for order id={}", orderId);
    }
}
