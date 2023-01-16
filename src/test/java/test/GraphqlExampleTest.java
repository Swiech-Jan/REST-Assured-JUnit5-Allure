package test;

import static common.BaseConfiguration.getTypesQuery;
import static common.GraphqlQueryBuilder.getQueryBody;
import static common.RequestSpecifications.graphqlExampleServiceRequestSpec;
import static common.ResponseSpecifications.graphqlExampleServiceResponseSpec;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.*;
import io.qameta.allure.*;


public class GraphqlExampleTest {

    @Test
    @Feature("GraphQL")
    @Epic("Epic 1")
    @Story("Story 1")
    @Description("GraphQL example test")
    @Severity(SeverityLevel.CRITICAL)
    public void testGraphqlSampleTestWithResponseValidation() {

        given().spec(graphqlExampleServiceRequestSpec())
                .body(getQueryBody(getTypesQuery, 1))
                .when().post()
                .then().spec(graphqlExampleServiceResponseSpec())
                .and().log().all()
                .and().assertThat().body("data.pokemon_v2_type[0].id", equalTo(1));
    }
}
