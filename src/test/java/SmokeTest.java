import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class SmokeTest {

    @Test
    void test1() {

        Response response = get("https://jsonplaceholder.typicode.com/albums/1");

        System.out.println("Response: : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        expect().statusCode(200);

    }
    @Test
    void test2() {

        Response response = get("https://jsonplaceholder.typicode.com/albums/1");

        System.out.println("Response: : " + response.asString());
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Header : " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        expect().statusCode(200);

    }
}