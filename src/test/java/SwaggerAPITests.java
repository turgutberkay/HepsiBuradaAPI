import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class SwaggerAPITests {

    @Test
    public void testSwaggerClientGeneration(){
        given()
                .when()
                .get("https://generator.swagger.io/api/gen/clients/swift")
                .then()
                .statusCode(200);
    }
    @Test
    public void testSwaggerServerGeneration() {
        String requestBody = "{" +
                "\"spec\": {" +
                "\"openapi\": \"3.0.0\"," +
                "\"info\": {" +
                "\"title\": \"My API\"," +
                "\"version\": \"1.0.0\"" +
                "}," +
                "\"paths\": {" +
                "\"/example\": {" +
                "\"get\": {" +
                "\"summary\": \"Get example data\"," +
                "\"responses\": {" +
                "\"200\": {" +
                "\"description\": \"Successful response\"" +
                "}" +
                "}" +
                "}" +
                "}" +
                "}" +
                "}," +
                "\"options\": {}," +
                "\"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\"," +
                "\"authorizationValue\": {}," +
                "\"usingFlattenSpec\": true," +
                "\"securityDefinition\": {}" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("https://generator.swagger.io/api/gen/servers/spring")
                .then()
                .statusCode(200);
    }


}
