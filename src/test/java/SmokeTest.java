import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class SmokeTest {

    @Test
    @Feature("Smoke Test 1")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("Test 1 Description")
    @Severity(SeverityLevel.CRITICAL)
    void test1() {

        Response response = get("https://jsonplaceholder.typicode.com/albums/1");

        System.out.println("Response: : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        expect().statusCode(200);

    }
    @Test
    @Feature("Smoke Test 2")
    @Epic("Epic 2")
    @Story("Story 2")
    @Description("Test 2 Description")
    @Severity(SeverityLevel.NORMAL)
    void test2() {

        Response response = get("https://jsonplaceholder.typicode.com/albums/1");

        System.out.println("Response: : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        expect().statusCode(200);

    }
}