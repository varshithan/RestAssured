package Trello.RestAutomation;

import java.io.File;
import java.io.Reader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;

import com.opencsv.CSVReader;

import java.io.*;

@SuppressWarnings("unused")
public class TestData 
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	static Map<String, String> map= new LinkedHashMap();
	static  String key;
	static  String token;
	static  String boardName;
	static  String cardName1,cardName2;
	static  String listName1,listName2;
	static  String labelName1,labelName2;
	static  String labelColor1,labelColor2;
	static  String imageUrl1,imageUrl2;
	@SuppressWarnings("resource")
	@BeforeTest
	public  void testData()
	{ 
		try { 
			File file =new File("/home/varshitha/Desktop/Ecllipse/RestAutomation/src/test/resource/Trello.csv");
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);

			String[] line;  

			while ((line = csvReader.readNext()) != null) 
			{ 
				map.put(line[0], line[1]);
			} 
			key=map.get("key");
			token=map.get("token");
			boardName=map.get("board name");
			listName1=map.get("list1 name");
			listName2=map.get("list2 name");
			cardName1=map.get("card1 name");
			cardName2=map.get("card2 name");
			labelName1=map.get("label1 name");
			labelName2=map.get("label2 name");
			labelColor1=map.get("label2 color");
			labelColor2=map.get("label2 color");
			imageUrl1=map.get("URL1");
			imageUrl2=map.get("URL2");



		}

		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 

}
