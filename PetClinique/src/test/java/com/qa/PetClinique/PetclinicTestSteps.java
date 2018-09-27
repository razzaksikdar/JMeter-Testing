package com.qa.PetClinique;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

public class PetclinicTestSteps {

	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	
    private static final LogStatus LogStatus = null;
	WebDriver driver;
    private static ExtentReports  reports = new ExtentReports(Constants.report, true);
    public ExtentTest test;

    @Before
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown()
    {
        driver.quit();
        reports.endTest(test);
        reports.flush();
    }
    
    @Given("^a vet$")
    public void a_vet()  {
        // Code to turns the phrase above into concrete actions
    	
    	// Application status check
    	
    	driver.get(Constants.mainUrl);
    	test=reports.startTest("PetClinic Test Report");
    	test.log(LogStatus.INFO,"Browser Started started with PetClinic Application");
 
    	
        if(driver.getCurrentUrl().equals(Constants.mainUrl))
        {
            test.log(LogStatus.PASS, "Application accessed correctly");
        }
        else
        {
            test.log(LogStatus.FAIL, "Test Failed!");
        }

        assertEquals(driver.getCurrentUrl(), Constants.mainUrl);
  
        //Vet User Check


	
	
	request=given().contentType(ContentType.JSON);
	
	request.header("Content-Type", "application/json");
	
	response= request.when().get("http://10.0.10.10:9966/petclinic/api/vets");
	
     System.out.println(	response.body().asString().contains("James"));		

     String[] fef = response.body().asString().split(":");
	
	
     for ( String s : fef) {
    	 
    		if(response.body().asString().contains("James")) {
    		      
            }
      
    		 test.log(LogStatus.PASS, "Vat Exist");
}
	
	
//	
//	for(int i= 0; i<response.length(); i++) {
//		
//	}
	
//	JSONObject obj=new JSONObject(response.body().asString());
//	JSONArray results = obj.getJSONArray("content");
//	
//	for (Object o: results)
//{
//		JSONObject objx=(JSONObject) o;
//	String holtName=objx.getString("firstName");
//		
//	if(holtName.equals("James")) {
//			String js=objx.toString();
//			System.out.println(js);
//		}
//	
//	}
      
        
        
    }

    @When("^I click on some records$")
    public void i_click_on_some_records()  {
        // Code to turns the phrase above into concrete actions
        

    	request=given().contentType(ContentType.JSON);
    	
    	request.header("Content-Type", "application/json");
    	
    	response= request.when().get("http://10.0.10.10:9966/petclinic/api/pets");
    	
    	driver.get(Constants.PetApiUrl);
  
    	
    	  if(driver.getCurrentUrl().equals(Constants.PetApiUrl))
          {
              test.log(LogStatus.PASS, "Pet app accessed correctly");
          }
          else
          {
              test.log(LogStatus.FAIL, "Test Failed!");
          }

          assertEquals(driver.getCurrentUrl(), Constants.PetApiUrl);
    	
        
    }

    @Then("^I can see the care available for animals$")
    public void i_can_see_the_care_available_for_animals()  {
        // Code to turns the phrase above into concrete actions
    	
    	request=given().contentType(ContentType.JSON);
    	
    	request.header("Content-Type", "application/json");
    	
    	response= request.when().get("http://10.0.10.10:9966/petclinic/api/pets");
    	
         System.out.println(response.body().asString());		

         String[] fef = response.body().asString().split(":");
    	
    	
         for ( String s : fef) {
        	 
        		if(response.body().asString().contains("Basil")) {
        		      
                }
          
        		 test.log(LogStatus.PASS, "Vat Exist");
    }
        
    }

    @Given("^an admin$")
    public void an_admin()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @When("^I update a record$")
    public void i_update_a_record()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @Then("^the correct details are now shown$")
    public void the_correct_details_are_now_shown()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @When("^I delete a animal$")
    public void i_delete_a_animal()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @Then("^emails arent sent to deceased annimals$")
    public void emails_arent_sent_to_deceased_annimals()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @When("^I add new records$")
    public void i_add_new_records()  {
        // Code to turns the phrase above into concrete actions
    	
    	
    	RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";
 	    request = RestAssured.given();
 	    
 	    request.header("Content-Type","application/json");

 		
 		JSONObject owner = new JSONObject();
 		JSONArray pets = new JSONArray();
 		
 		JSONObject pet = new JSONObject();
 		JSONObject type = new JSONObject();
 		JSONArray visits = new JSONArray();
 		JSONObject visit = new JSONObject();
 		
 		visit.put("date", "2014/12/16");
 		visit.put("description", "april");
 		visit.put("id", 31);
 		visit.put("pet", pet);
 		
 		visits.put(visit);
 		
 		type.put("id", 0);
 		type.put("name","maxi");
 		pet.put("type", type);
 		pet.put("birthDate", "12/12/12");
 		pet.put("id", 17);
 		pet.put("name", "master");
 		pet.put("owner", owner);
 		pet.put("visits", visits);
 		
 		pets.put(pet);
 		
 		owner.put("address","first line");
 		owner.put("city","Dhaka");
 		owner.put("firstName", "Mikel");
 		owner.put("id", 96);
 		owner.put("lastName", "Jekson");
 		owner.put("pets", pets);
 		owner.put("telephone", "166658");
 		
 		request.body(owner.toString());
 		response = request.post("http://10.0.10.10:9966/petclinic/api/owners");
 		
 		
    	
        
    }

    @Then("^the records are correct$")
    public void the_records_are_correct()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @When("^I add new owners to the records$")
    public void i_add_new_owners_to_the_records()  {
        // Code to turns the phrase above into concrete actions
        
    }

    @Then("^the details show the change$")
    public void the_details_show_the_change()  {
        // Code to turns the phrase above into concrete actions
        
    }


    
    
}
