package com.qa.PetClinique;

import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestSuit {
	
//	@FindBy(xpath = "")
//	private WebElement ;
//	
//	@FindBy(id="")
//	private WebElement ;
//	
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
	@Test
	public void getObjectByName() {

      //Vet User Check [GET TEST]
      
    	request=given().contentType(ContentType.JSON);
    	
		request.header("Content-Type", "application/json");
		
		response= request.when().get("http://10.0.10.10:9966/petclinic/api/vets");
		json = response.then().statusCode(200);
		
		
	System.out.println(	response.body().asString().contains("James"));		
	
	String[] fef = response.body().asString().split(":");
		
		
	for ( String s : fef) {
		
		System.out.println(s);
		
	}
		
//		String s=response.body().asString();
//		int i=s.indexOf("{");
//		s = s.substring(i);
//	
//		JSONObject obj=new JSONObject(s.trim());
//		
//		JSONArray results = obj.getJSONArray("");
//		
//		for (Object o: results)
//		{
//			JSONObject objx=(JSONObject) o;
//			String holtName=objx.getString("firstName");
//			
//			if(holtName.equals("James")) {
//				String js=objx.toString();
//				System.out.println(js);
//			}
//		
//		}
		
	}
	
	@Test
	public void PostTest() {
		JSONObject obj =new JSONObject();
		request=given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		obj.put("firstName", "Miki");
		obj.put("lastName", "mouse");
		obj.put("address", " first lane");
		obj.put("city", "Manchester");
		obj.put("telephone", "123454");
		request.body(obj.toString());
		response=request.post("http://10.0.10.10:9966/petclinic/api/owners/11");
		System.out.println("Post test1 response code: "+response.getStatusCode());

		
	}
	
	@Test
	public void DeleteTest() {
		
		Response response = given().contentType(ContentType.JSON).when()
				.delete("http://10.0.10.10:9966/petclinic/api/owners/1");
		System.out.println("Delete status code: "+response.getStatusCode());
		System.out.println("Delete status code as string: "+response.asString());
	}

	@Test
	public void deletById() {
		request=given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		response= request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
		
		
		JSONObject obj=new JSONObject(response.body().asString());
		JSONArray results = obj.getJSONArray(response.body().asString());
		JSONObject objx=null;
		
		for(int i= 0; i<results.length(); i++) {
			
			objx=results.getJSONObject(i);
			int x=objx.getInt("id");
			if(x==31) {
				Response response = given().contentType(ContentType.JSON).when()
						.delete("http://10.0.10.10:9966/petclinic/api/owners"+x);
			}
			
		}
		
	}
}
