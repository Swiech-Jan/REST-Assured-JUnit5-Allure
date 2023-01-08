package testSuite;

import static io.restassured.RestAssured.*;
import static common.RequestSpecifications.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import common.GraphQLQuery;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import org.json.*;
import static org.hamcrest.MatcherAssert.assertThat;

// refer to https://testautomationu.applitools.com/automating-your-api-tests-with-rest-assured/chapter1.html

// First add POM dependency - org.json


public class GraphQLExampleTest {

    @Test
    @Feature("GraphQL")
    @Epic("Epic 3")
    @Story("Story 3")
    @Description("GraphQL example test")
    @Severity(SeverityLevel.CRITICAL)
    public void test3() {

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("query getTypes($limit: Int) {pokemon_v2_type(limit: $limit) { id generation_id name }}");

        JSONObject variables = new JSONObject();
        variables.put("limit", 10);

        query.setVariables(variables.toString());

        given().
                contentType(ContentType.JSON).
                body(query).
                when().
                post("https://beta.pokeapi.co/graphql/v1beta").
                then().
                assertThat().
                statusCode(200);
    }

}
