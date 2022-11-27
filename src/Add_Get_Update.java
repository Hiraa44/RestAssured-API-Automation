import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.CreateUser;

public class Add_Get_Update extends CommonMethods {
	//Working Code
	
	@Test
	 public void  addUser() {
		CreateUser user1=new CreateUser();
		user1.setEmail("hira02@gmail.com");
		user1.setGender("female");
		user1.setStatus("active");
		user1.setName("hira");
    	 //CreateUser
 		RestAssured.given().spec(requestSpec).body(user1).
	      when().post("/public/v2/users").then().log().all().statusCode(201);
	}
	@Test
	void GetUser() {
 		//GetUser
 		Response response= RestAssured.given().spec(requestSpec).when().get("/public/v2/users/2450").then().statusCode(200).extract().response();
 		  int status=response.statusCode();
	
		  
          Assert.assertEquals(status, 200, "Correct status is returned");
          System.out.println(status);
          JsonPath Jsonresponse = response.jsonPath();
            int id = Jsonresponse.get("id");
          //String name=Jsonresponse.getString("name");
            System.out.println(id);
         // Assert.assertEquals(id,2668);
        //  Assert.assertEquals(name,"Anusuya Gandhi");
        //  System.out.println(name);
	}
         //UpdateUser
	@Test
      public void UpdateUser() {    
          System.out.println("=========================");
          String UpdatedString="{\"id\":4118,\"name\":\"Vishwamitra Pillai\",\r\n"
          		+ "\"email\":\"pillai_vishwamitra@schmitt.info30\",\r\n"
          		+ "\"gender\":\"male\",\r\n"
          		+ "\"status\":\"inactive\"}";
         Response response1= RestAssured.given().spec(requestSpec).body(UpdatedString)
        		 .when().put("/public/v2/users/4597").then().statusCode(200)
          .extract().response();
         String updatedStatus="inactive";
         JsonPath Jsonresponse1 = response1.jsonPath();
        int uid = Jsonresponse1.get("id");
         String uname=Jsonresponse1.getString("name");
        System.out.println(uid);
        // Assert.assertEquals(uid,4118);
        // Assert.assertEquals(uname,"Anusuya Gandhi");
         System.out.println(uname);
         String status1=Jsonresponse1.getString("status");
         Assert.assertEquals(status1,updatedStatus);
	 }
	 
}
