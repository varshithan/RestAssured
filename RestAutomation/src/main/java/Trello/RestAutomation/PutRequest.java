package Trello.RestAutomation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@SuppressWarnings("unused")
public class PutRequest extends PostRequest
{
	@SuppressWarnings("unchecked")
	public void updateList()
	{
	RequestSpecification request =RestAssured.given();
	request.header("Content-type", "application/json");
	JSONObject json= new JSONObject();
	json.put("name","Manager");
	json.put("key", key);
	json.put("token", token);
	request.body(json.toString());
	Response response=request.put(url+"list/"+listid2);
	int code = response.getStatusCode();
	assertEquals(code, 200);
	}
	@SuppressWarnings("unchecked")
	public void updateCard()
	{
	RequestSpecification request =RestAssured.given();
	request.header("Content-type", "application/json");
	JSONObject json= new JSONObject();
	json.put("name","TeamLead");
	json.put("key", key);
	json.put("token", token);
	request.body(json.toString());
	Response response=request.put(url+"cards/{id}/", cardid2);
	int code = response.getStatusCode();
	assertEquals(code, 200);
	}
	@SuppressWarnings("unchecked")
	public void updateLabel()
	{
	RequestSpecification request =RestAssured.given();
	request.header("Content-type", "application/json");
	JSONObject json= new JSONObject();
	json.put("name","TeamMember");
	json.put("key", key);
	json.put("token", token);
	request.body(json.toString());
	Response response=request.put(url+"labels/{id}/", labelid2);
	int code = response.getStatusCode();
	assertEquals(code, 200);
	}
	
}
