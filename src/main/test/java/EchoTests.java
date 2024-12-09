import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTests{

    private final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetMethod() {
        given()
                .when()
                .get(BASE_URL + "/get")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/get"));
    }

    @Test
    public void testPostMethod() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"key\": \"value\" }")
                .when()
                .post(BASE_URL + "/post")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("value"));
    }

    @Test
    public void testPutMethod() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"key\": \"updatedValue\" }")
                .when()
                .put(BASE_URL + "/put")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("updatedValue"));
    }

    @Test
    public void testDeleteMethod() {
        given()
                .when()
                .delete(BASE_URL + "/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo(BASE_URL + "/delete"));
    }

    @Test
    public void testPatchMethod() {
        given()
                .contentType(ContentType.JSON)
                .body("{ \"key\": \"patchedValue\" }")
                .when()
                .patch(BASE_URL + "/patch")
                .then()
                .statusCode(200)
                .body("json.key", equalTo("patchedValue"));
    }
}