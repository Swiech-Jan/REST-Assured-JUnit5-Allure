package testSuite;

import static io.restassured.RestAssured.*;

import common.GraphQLQuery;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import org.json.*;

import static org.hamcrest.MatcherAssert.assertThat;


// First add POM dependency - org.json


public class GraphqlExampleTests {

    @Test
    @Feature("GraphQL")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("GraphQL example test")
    @Severity(SeverityLevel.CRITICAL)
    public void graphqlSampleTestWithResponseValidation() {

        GraphQLQuery query = new GraphQLQuery();
        query.setQuery("query getTypes($limit: Int) {pokemon_v2_type(limit: $limit) { id generation_id name }}");

        JSONObject variables = new JSONObject();
        variables.put("limit", 10);

        query.setVariables(variables.toString());

        System.out.println("This are query variables: " + variables);
        System.out.println("This is query body: " + query);

        given()
                .contentType(ContentType.JSON)
                .body(query)
                .when()
                .post("https://beta.pokeapi.co/graphql/v1beta")
                .then()
                .log().body()
                .and()
                .assertThat()
                .statusCode(200);
    }
}
