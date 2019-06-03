package Trello.RestAutomation;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class TrelloTest extends DeleteRequest
{
	
	@Test(priority=1)
	public void post() throws ParseException
	{
	    createBoard();
		createList1();
		createCard1();
		createlabel1();
		attachFile1();
		createList2();
		createCard2();
		createlabel2();
		attachFile2();
	}

	
	@Test(priority=2)
	public void put()
	{
		updateList();
 		updateCard();
		updateLabel();
	}
	@Test(priority=3)
	public void delete()
	{
		deleteCard();
	}

}


