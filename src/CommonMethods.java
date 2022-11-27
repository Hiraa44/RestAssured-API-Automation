import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonMethods {
	 String token="be8f1f11ccafe8d4240ce5651c1eeedabf0982ce18e7932e79094dc9288098cf";
	 AuthenticationScheme authScheme = RestAssured.oauth2(token);
	 RequestSpecification requestSpec = new RequestSpecBuilder().setBaseUri("https://gorest.co.in").
		        setContentType(ContentType.JSON).
		        addHeader("Content-Type","application/json").setAuth(authScheme).
		       // addHeader("Authorization","application/json").
		       // addHeader("Authorization",authToken).
		        build();
}
