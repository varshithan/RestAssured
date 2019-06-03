package Trello.RestAutomation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class DeleteRequest extends PutRequest
{
@SuppressWarnings("unchecked")
public void deleteCard() 
{
	RequestSpecification request =RestAssured.given();
	request.header("Content-type", "application/json");
	JSONObject json= new JSONObject();
	json.put("key",key);
	json.put("token",token);
	request.body(json.toString());
	Response response=request.delete(url+"cards/"+cardid2);
	int code = response.getStatusCode();
	assertEquals(code, 200);	   

}
}

