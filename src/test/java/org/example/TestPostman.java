package org.example;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TestPostman {
    private static final String url = "https://postman-echo.com";
    @Test
    public void testGet() {
        Response response = given()
                .when()
                .get("https://postman-echo.com/get?foo1=bar1&foo2=bar2");
        assertEquals(response.getStatusCode(), 200);
        assertEquals(response.jsonPath().getString("args.foo1"), "bar1");
        assertEquals(response.jsonPath().getString("args.foo2"), "bar2");
    }
    @Test
    public void testPost() {
        Response response = given()
                .contentType("application/x-www-form-urlencoded")
                .queryParam("key", "value","description")
                .when()
                .post("https://postman-echo.com/post");
        assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void testPut() {
        Response response = given()
                .contentType("text/plain")
                .queryParam("key", "value","description")
                .when()
                .put("https://postman-echo.com/put");
        assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void testPatch() {
        Response response = given()
                .contentType("text/plain")
                .queryParam("key", "value","description")
                .when()
                .put("https://postman-echo.com/patch");
        assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void testDelete() {
        Response response = given()
                .when()
                .delete("https://postman-echo.com/delete");
        assertEquals(response.getStatusCode(), 200);
    }
}
