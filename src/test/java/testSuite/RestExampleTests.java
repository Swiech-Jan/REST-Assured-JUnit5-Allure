package testSuite;

import static io.restassured.RestAssured.*;
import static common.RequestSpecifications.*;
import static common.ResponseSpecifications.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

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
                .then().spec(restExampleServiceResponseSpec())
                .and().log().all()
                .extract().response();
    }

    @Test
    @Feature("Smoke Test 2")
    @Epic("Epic 2")
    @Story("Story 2")
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

    @Test
    @Feature("Smoke Test 3")
    @Epic("Epic 3")
    @Story("Story 3")
    @Description("Simple JSON path assertion using hamcrest assertions")
    @Severity(SeverityLevel.CRITICAL)
    void basicJsonPathAssertion() {

        Response response = given()
                .log().all()
                .spec(restExampleServiceRequestSpec())
                .when()
                .get("/users/1")
                .then()
                .assertThat().body("address.street", equalTo("Kulas Light"))
                .and().spec(restExampleServiceResponseSpec())
                .and().log().all()
                .extract().response();
    }
}