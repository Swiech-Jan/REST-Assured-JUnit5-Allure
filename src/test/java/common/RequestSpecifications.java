package common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static common.BaseConfiguration.*;

public class RequestSpecifications {

	public static RequestSpecification RestExampleServiceRequestSpec() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(restServiceExampleUrl);
		//builder.setProxy("exampleProxyUrl", 8080)
		builder.setAccept("application/json");
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
	}

	public static RequestSpecification GraphqlExampleServiceRequestSpec() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.setBaseUri(graphqlServiceExampleUrl);
		//builder.setProxy("exampleProxyUrl", 8080)
		builder.setContentType("application/json");
		RequestSpecification requestSpec = builder.build();
		return requestSpec;
	}

}
