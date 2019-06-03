package Trello.RestAutomation;

import static org.testng.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Hello world!
 *
 */
@SuppressWarnings("unused")
public class PostRequest extends TestData
{

	public  String url="https://api.trello.com/1/";
	public  String boardid,listid1,listid2,cardid1,cardid2,labelid1,labelid2;

	@SuppressWarnings("unchecked")
	
	public void createBoard() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token",token);
		json.put("name",boardName);
		request.body(json.toString());
		Response response=request.post(url+"boards");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		boardid= (String) js.get("id");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   

	}
	@SuppressWarnings("unchecked")
	public void createList1() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", listName1);
		json.put("idBoard", boardid);
		request.body(json.toString());
		Response response=request.post(url+"lists");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		listid1= (String) js.get("id");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   

	}
	@SuppressWarnings("unchecked")
	public void createList2() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", listName2);
		json.put("idBoard", boardid);
		request.body(json.toString());
		Response response=request.post(url+"lists");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		listid2= (String) js.get("id");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   

	}
	@SuppressWarnings("unchecked")
	public void createCard1() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", cardName1);
		json.put("idList", listid1);
		request.body(json.toString());
		Response response=request.post(url+"cards");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		cardid1= (String) js.get("id");
		int code = response.getStatusCode();
		System.out.print(code + "before");
		assertEquals(code, 200);
		System.out.println(code + "code");

	}
	public void createCard2() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", cardName2);
		json.put("idList", listid2);
		request.body(json.toString());
		Response response=request.post(url+"cards");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		cardid2= (String) js.get("id");
		int code = response.getStatusCode();
		assertEquals(code, 200);	
		

	}
	@SuppressWarnings("unchecked")
	public void createlabel1() throws ParseException
	{
		
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", labelName1);
		json.put("color", labelColor1);
		json.put("idBoard", boardid);
		request.body(json.toString());
		System.out.println(cardid1);
		Response response=request.post(url+"cards/"+cardid1+"/labels");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		labelid1= (String) js.get("id");
		int code = response.getStatusCode();
		//System.out.println(response.asString());
		assertEquals(code, 200);	   
	}
	@SuppressWarnings("unchecked")
	public void createlabel2() throws ParseException
	{
		RequestSpecification request =RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token", token);
		json.put("name", labelName1);
		json.put("color", labelColor1);
		request.body(json.toString());
		Response response=request.post(url+"cards/"+cardid2+"/labels");
		JSONParser jp= new JSONParser();
		jp.parse(response.asString());
		JSONObject js= (JSONObject) new JSONParser().parse(response.asString());
		labelid2= (String) js.get("id");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   
	}
	@SuppressWarnings("unchecked")
	public void attachFile1()
	
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token",token);
		json.put("url",imageUrl1);
		request.body(json.toString());
		Response response=request.post(url+"cards/"+cardid1+"/attachments");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   

	}
	@SuppressWarnings("unchecked")
	public void attachFile2()
	
	{
		RequestSpecification request = RestAssured.given();
		request.header("Content-type", "application/json");
		JSONObject json= new JSONObject();
		json.put("key",key);
		json.put("token",token);
		json.put("url",imageUrl2);
		request.body(json.toString());
		Response response=request.post(url+"cards/"+cardid2+"/attachments");
		int code = response.getStatusCode();
		assertEquals(code, 200);	   

	}


}
