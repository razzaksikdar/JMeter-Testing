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
		
//		System.out.println(s);
		
	}
		
//		String s=response.body().asString();
//		int i=s.indexOf("[");
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

		
		request=given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		
		
		JSONObject owner = new JSONObject();
 		JSONArray pets = new JSONArray();
 		
 		JSONObject pet = new JSONObject();
 		JSONObject type = new JSONObject();
 		JSONArray visits = new JSONArray();
// 		JSONObject visit = new JSONObject();
// 		
// 		visit.put("date", "yyyy/MM/dd");
// 		visit.put("description", "April");
// 		visit.put("id", 0);
// 		visit.put("pet", pet);
// 		
// 		visits.put(visit);
// 		
// 		type.put("id", 0);
// 		type.put("name","maxi");
 		pet.put("type", type);
 		pet.put("birthDate", "2018-09-27T08:50:25.563Z");
 		//pet.put("id", 17);
 		pet.put("name", "master");
 		pet.put("owner", 7);
 		pet.put("visits", visits);
 		
 		pets.put(pet);
// 		visit.put("pet", pet);
 		
 		
 		owner.put("address","first line");
 		owner.put("city","Dhaka");
 		owner.put("firstName", "lool");
 		//owner.put("id", 0);
 		owner.put("lastName", "Jekson");
 		owner.put("pets", pets);
 		owner.put("telephone", "166658");
 		
 		request.body(owner.toString());
 		response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
		System.out.println("Anis addition: "+response.getStatusCode());		
	}
	
	@Test
	public void DeleteTest() {
		
		Response response = given().contentType(ContentType.JSON).when()
				.delete("http://10.0.10.10:9966/petclinic/api/owners/2");
		System.out.println("Delete status code: "+response.getStatusCode());
		System.out.println("Delete status code as string: "+response.asString());
	}

	@Test
	public void deletById() {
		request=given().contentType(ContentType.JSON);
		request.header("Content-Type", "application/json");
		response= request.when().get("http://10.0.10.10:9966/petclinic/api/owners");
		json=response.then().statusCode(200);
				
		JSONObject obj=new JSONObject("{" + "myArray:" + response.body().asString() +"}");
		JSONArray results = obj.getJSONArray("myArray");
		JSONObject objx=null;
		
		for(int i= 0; i<results.length(); i++) {
			objx=results.getJSONObject(i);
			System.out.println("delete"+objx.getInt("id"));
			int x=objx.getInt("id");
			if(x==10) {
				Response response = given().contentType(ContentType.JSON).when()
						.delete("http://10.0.10.10:9966/petclinic/api/owners/"+x);
			}
			
		}
		
	}
}
