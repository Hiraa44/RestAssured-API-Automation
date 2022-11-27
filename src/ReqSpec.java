

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import Data.payload;
public class ReqSpec {
     public static void main(String[] args) throws IOException{
	//@Test
	//public void CreateUser() {
    	 String JsonBody="{\"name\":\"Vishwamitra Pillai\",\r\n"
    		   		+ "\"email\":\"pillai_vishwamitra@schmitt.info24\",\r\n"
    		   		+ "\"gender\":\"female\",\"status\":\"active\"}";
    	 String token="038f2fd3b9431b5fb34a889c9b4bf8eb29bcb72b16ea02535a151106bf94eff7";
    	 String authToken=token;
    	 
		//RequestSpecBuilder reqSpeBuilder; 
		System.out.println(JsonBody);
		//final RequestSpecification reqSpec;
		//reqSpeBuilder = new RequestSpecBuilder();
		//reqSpeBuilder.setBaseUri("https://gorest.co.in");
		//reqSpeBuilder.setBasePath("public/v2");
		
		//reqSpeBuilder.setBody(JsonBody);
		//Header requestHeader1 = new Header("Authorization",token;);
		//RequestSpecification requestSpec;
		//requestSpec= RestAssured.given();
		//requestSpec.baseUri("https://gorest.co.in");
		//requestSpec.header("Authorization",authToken);
		//requestSpec.contentType(ContentType.JSON);
		//requestSpec.accept(ContentType.JSON);
		RestAssured.requestSpecification = new RequestSpecBuilder()
			     .build().header("Authorization", "Bearer " + token).baseUri("https://gorest.co.in");
		
		//reqSpeBuilder.addQueryParam("page", "2");
//		AuthenticationScheme authScheme = RestAssured.oauth("", "", "", "");
//		reqSpeBuilder.setAuth(authScheme);
		//reqSpec = reqSpeBuilder.build();
       //API for creating user
		//String token="dd220f7d313c85fb41ef5e4effa96ec78482caf4be7e136dc2405c9aaa4c704e";
		//RequestSpecBuilder builder=new RequestSpecBuilder();
	   // builder.setBaseUri("https://gorest.co.in");
	   // builder.setContentType("application/json");
	   // builder.addHeader("Authorization", authToken);
	   // builder.setContentType("application/json");
	   // RestAssured.baseURI = "https://gorest.co.in";
	   
	  // request=builder.build();
	  // byte[] b = Files.readAllBytes(Paths.get("payload.json"));

	      //convert byte array to string
	      //String bdy = new String(b);
	     // System.out.println(b);
      String Postresult=given().spec(requestSpecification).
    		  //headers( "Authorization",  "Bearer " + token)
    		 body(JsonBody).
             // "Content-Type",
            //  ContentType.JSON,
            //  "Accept",
            //  ContentType.JSON)
    		  
      when().post("public/v2/users").then().log().all().statusCode(201).extract().response().asString();
      System.out.println(Postresult);
      System.out.println("=================================================");
      //API for getting the user
      Response response=given().headers( "Authorization",
              "Bearer " +token,
              "Content-Type",
              ContentType.JSON,
              "Accept",
              ContentType.JSON)
    		  .when().get("/public/v2/users/4096").then().statusCode(200).extract().response();
       // System.out.println(Getresult);
    		 // Assertions.assertEquals(200, response.statusCode());
    //  Assertions.assertEquals("bax", response.jsonPath().getString("title"));
     // Assertions.assertEquals("1", response.jsonPath().getString("userId"));
    //  Assertions.assertEquals("1", response.jsonPath().getString("id"));
    		  int status=response.statusCode();
    		  
              Assert.assertEquals(status, 200, "Correct status is returned");
              System.out.println(status);
              JsonPath Jsonresponse = response.jsonPath();
              int id = Jsonresponse.get("id");
              String name=Jsonresponse.getString("name");
              System.out.println(id);
              Assert.assertEquals(id,4096);
              Assert.assertEquals(name,"Vishwamitra Pillai");
              System.out.println(name);
              //System.out.println(payload.getUser());
              
   }
}


