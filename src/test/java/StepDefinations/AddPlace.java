package StepDefinations;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;

import Utils.APIResources;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.GeneratePayload;
import resources.RequestBuilder;

public class AddPlace extends RequestBuilder {
	RequestSpecification request;
	ResponseSpecification res;
	Response response;
	JsonPath js;
	GeneratePayload payload = new GeneratePayload();
	@Given("add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException { 
         request = given().spec(request()).body(payload.addPlace(name, language, address));
	}
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource,String method) {
		 APIResources resAPI = APIResources.valueOf(resource); 
		 System.out.println(resAPI.getResource());
		 if(method.equals("post")) {
         response = request.when().post(resAPI.getResource());
		 } else if(method.equals("get")){
			 response = request.when().get(resAPI.getResource());
		 }
	}
	@Then("the API call got succes with status code {int}")
	public void the_api_call_got_succes_with_status_code(Integer int1) {
       assertEquals(response.statusCode(),200);
       System.out.println(response.asString());
       
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
       String res = response.asString();
        js = new JsonPath(res);
       assertEquals(js.getString(key),value);
	}
	
	@Then("place id should match in the {string} {string}")
	public void place_id_should_match_in_the(String resource,String name) throws IOException {
       String placeID = js.getString("place_id");
       request = given().spec(request()).queryParam("place_id", placeID);
       user_calls_with_post_http_request(resource,"get");
       String res = response.asString();
       js = new JsonPath(res);
       String actualname = js.getString("name");
       assertEquals(actualname,name);
	}


}
