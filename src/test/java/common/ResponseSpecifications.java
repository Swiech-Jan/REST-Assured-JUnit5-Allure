package common;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecifications {

    public static ResponseSpecification restExampleServiceResponseSpec() {

        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        builder.expectContentType(ContentType.JSON);
        ResponseSpecification responseSpec = builder.build();
        return responseSpec;

    }
}
