package test;

import static io.restassured.RestAssured.*;
import static common.RequestSpecifications.*;
import static common.ResponseSpecifications.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;

public class RestExampleTest {
    @Test
    @Feature("Smoke Test 1")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("Simple Get Request")
    @Severity(SeverityLevel.CRITICAL)
    void testBasicGetCall() {

        given()
                .spec(restExampleServiceRequestSpec())
                .when().get("/posts")
                .then().spec(restExampleServiceResponseSpec())
                .and().log().all();
    }

    @Test
    @Feature("Smoke Test 2")
    @Epic("Epic 2")
    @Story("Story 2")
    @Description("Schema validation example")
    @Severity(SeverityLevel.CRITICAL)
    void testBasicSchemaValidation() {

        // For JSON schema validation refer to:
        // https://json-schema.org/understanding-json-schema/
        // https://jsonschema.net/app/schemas/194490

        given()
                .spec(restExampleServiceRequestSpec()).log().all()
                .when().get("/posts/1")
                .then().spec(graphqlExampleServiceResponseSpec())
                .and().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemaTemplates/getOnePostSchema.json"))
                .and().log().all();
    }

    @Test
    @Feature("Smoke Test 3")
    @Epic("Epic 3")
    @Story("Story 3")
    @Description("Simple JSON path assertion using hamcrest assertions")
    @Severity(SeverityLevel.CRITICAL)
    void testBasicJsonPathAssertion() {

        given()
                .spec(restExampleServiceRequestSpec()).log().all()
                .when().get("/users/1")
                .then().spec(restExampleServiceResponseSpec())
                .and().assertThat().body("address.street", equalTo("Kulas Light"))
                .and().log().all();
    }

    @Test
    @Feature("Smoke Test 4")
    @Epic("Epic 4")
    @Story("Story 4")
    @Description("Example of data extraction from JSON response object")
    @Severity(SeverityLevel.CRITICAL)
    void testBasicDataExtractionFromJsonObject() {

        String streetName =
                given().spec(restExampleServiceRequestSpec()).log().all()
                        .when().get("/users/1")
                        .then().extract().path("address.street");

        System.out.println("This is extracted street value: " + streetName);
    }
}