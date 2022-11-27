import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class CreateUser {
	
  public static void main(String[] args) {
	  String Jsonbody="{\r\n"
	  		+ "    \"userId\": 10,\r\n"
	  		+ "    \"id\": 101,\r\n"
	  		+ "    \"title\": \"at nam consequatur ea labore ea harum\",\r\n"
	  		+ "    \"body\": \"cupiditate quo est a modi nesciunt soluta\\nipsa voluptas error itaque dicta in\\nautem qui minus magnam et distinctio eum\\naccusamus ratione error aut\"\r\n"
	  		+ "}";
	  RequestSpecBuilder reqSpeBuilder; 
		final RequestSpecification reqSpec;
		reqSpeBuilder = new RequestSpecBuilder();
		reqSpeBuilder.setBaseUri("https://jsonplaceholder.typicode.com");
		reqSpec = reqSpeBuilder.build();
		RestAssured.given().spec(reqSpec).body(Jsonbody).
	      when().post("posts").then().log().all().statusCode(201);
		
    	 
  }
}