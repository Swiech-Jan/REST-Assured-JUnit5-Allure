package testSuite;

import static io.restassured.RestAssured.*;
import static common.RequestSpecifications.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class RestExampleTests {

    @Test
    @Feature("Smoke Test 1")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("Simple Get Request")
    @Severity(SeverityLevel.CRITICAL)
    void basicGetCall() {

        Response response = given()
                .log().all()
                .spec(restExampleServiceRequestSpec())
                .when()
                .get("/posts")
                .then().log().all()
                .and().statusCode(200)
                .extract().response();

    }

    @Test
    @Feature("Smoke Test 1")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("Simple Get Request")
    @Severity(SeverityLevel.CRITICAL)
    void basicSchemaValidation() {

        Response response = given()
                .log().all()
                .spec(restExampleServiceRequestSpec())
                .when()
                .get("/posts/1")
                .then().log().all()
                .and().assertThat().body(matchesJsonSchemaInClasspath("schemaTemplates/getOnePostSchema"))
                .and().statusCode(200)
                .extract().response();

    }
}