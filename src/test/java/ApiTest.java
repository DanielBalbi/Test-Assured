import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiTest {
	String MyId;
	
	@Test
	public void testPetsGet() {
		
	RestAssured.baseURI = "https://petstore.swagger.io/v2/pet";
		
		String respuesta = RestAssured.given()
		.when()
		.get("/"+MyId)
		.then()
			.statusCode(200)
		.extract()
		.body()
		.asString();
		
		System.out.println(respuesta);
		System.out.println("GetTest de Pet **************************************************************************");
		
	    }	

	@Test
	public void testPetPost() {
		
		String requestBody = "{\n" + 
				"  \"id\": 0,\n" + 
				"  \"category\": {\n" + 
				"    \"id\": 0,\n" + 
				"    \"name\": \"string\"\n" + 
				"  },\n" + 
				"  \"name\": \"Mora\",\n" + 
				"  \"photoUrls\": [\n" + 
				"    \"string\"\n" + 
				"  ],\n" + 
				"  \"tags\": [\n" + 
				"    {\n" + 
				"      \"id\": 0,\n" + 
				"      \"name\": \"string\"\n" + 
				"    }\n" + 
				"  ],\n" + 
				"  \"status\": \"available\"\n" + 
				"}";
	

	RestAssured.baseURI = "https://petstore.swagger.io/v2";

	Response nuevo = RestAssured.given()
					.header("Content-type", "application/json")
	                .and()
	                .body(requestBody)
	                .when()
	                .post("/pet")
	                .then()
	                .extract().response();

    Assert.assertEquals(nuevo.statusCode(),200);
	System.out.println(nuevo.statusCode());
	System.out.println(nuevo.asPrettyString());
	System.out.println(nuevo.jsonPath().getString("id"));
	MyId = nuevo.jsonPath().getString("id");
	
	System.out.println("Post de Pet **************************************************************************");

	        Assert.assertEquals("Mora", nuevo.jsonPath().getString("name"));
//AssertJUnit.assertEquals("baz", nuevo.jsonPath().getString("body"));
//AssertJUnit.assertEquals("1", nuevo.jsonPath().getString("userId"));
//AssertJUnit.assertEquals("1", nuevo.jsonPath().getString("id"));
		
	}
	
	@Test
	public void testPetsPut() {
		
		String requestBody = "{\n" + 
				"  \"id\":" + MyId + ",\n" + 
				"  \"category\": {\n" + 
				"    \"id\": 0,\n" + 
				"    \"name\": \"string\"\n" + 
				"  },\n" + 
				"  \"name\": \"Pichicho\",\n" + 
				"  \"photoUrls\": [\n" + 
				"    \"string\"\n" + 
				"  ],\n" + 
				"  \"tags\": [\n" + 
				"    {\n" + 
				"      \"id\": 0,\n" + 
				"      \"name\": \"string\"\n" + 
				"    }\n" + 
				"  ],\n" + 
				"  \"status\": \"available\"\n" + 
				"}";
	
		System.out.println(requestBody);

	RestAssured.baseURI = "https://petstore.swagger.io/v2";

	Response nuevo = RestAssured.given()
					.header("Content-type", "application/json")
	                .and()
	                .body(requestBody)
	                .when()
	                .put("/pet")
	                .then()
	                .extract().response();

    Assert.assertEquals(nuevo.statusCode(),200);
	System.out.println(nuevo.statusCode());
	System.out.println(nuevo.asPrettyString());
	System.out.println(nuevo.jsonPath().getString("id"));
	MyId = nuevo.jsonPath().getString("id");
	
	System.out.println("Put de Pet **************************************************************************");

	        Assert.assertEquals("Pichicho", nuevo.jsonPath().getString("name"));
//AssertJUnit.assertEquals("baz", nuevo.jsonPath().getString("body"));
//AssertJUnit.assertEquals("1", nuevo.jsonPath().getString("userId"));
//AssertJUnit.assertEquals("1", nuevo.jsonPath().getString("id"));
		
	}
	
	

}
