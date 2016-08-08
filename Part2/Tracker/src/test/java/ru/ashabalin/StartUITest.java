package ru.ashabalin;

import ru.ashabalin.models.*;
import ru.ashabalin.start.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

 /**
 * Created by Aleksei Shabalin.
 */

public class StartUITest{
	
	/**
	* Test checking method add task;
	*/
	@Test
	public void addTask() throws Exception{
		Tracker tracker = new Tracker();
		
		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		String[] answer = {"1", name, description, comment, "n", "2", "y"};
		StubInput stubInput = new StubInput(answer);
		StartUI startUi = new StartUI(stubInput, tracker);
		
		startUi.init();
	
		assertNotNull(stubInput.getOut());
	}

	/**
	 * Test checking method show all task;
	 */
	@Test
	public void ShowAllTask() throws Exception{
		Tracker tracker = new Tracker();

		String name1 = "First task";
		String description1 = "First description";
		String comment1 = "First comment";

		String name2 = "Second task";
		String description2 = "Second description";
		String comment2 = "Second comment";


		String[] answer = {"1", name1, description1, comment1, "n", "1", name2, description2, comment2, "n", "2", "y"};
		StubInput stubInput = new StubInput(answer);
		new StartUI(stubInput, tracker).init();

		assertThat(stubInput.getOut(), containsString("First task, First description"));
		assertThat(stubInput.getOut(), containsString("Second task, Second description"));
	}

	/**
	* Test checking method edit task;
	*/
	@Test
	public void EditTask() throws Exception {
		Tracker tracker = new Tracker();

		String name1 = "First task";
		String description1 = "First description";
		String comment1 = "First comment";

//		String name2 = "Second task";
		String description2 = "Second description";
		String comment2 = "Second comment";


		String[] answer = {"1", name1, description1, comment1, "y"};
		StubInput stubInput = new StubInput(answer);
		new StartUI(stubInput, tracker).init();

		Item[] testItem = new Item[1];
		testItem[0] = tracker.findByName(name1);

		String[] answerForEdit = {"3", testItem[0].getId(), description2, comment2, "n", "2", "y"};
		stubInput = new StubInput(answerForEdit);
		new StartUI(stubInput, tracker).init();

		assertThat(stubInput.getOut(), containsString("First task, Second description"));
		assertThat(stubInput.getOut(), containsString("Second comment"));
	}
	
	/**
	* Test checking method search task by ID;
	*/
	 @Test
	 public void FindByIdTask() throws Exception{
		 Tracker tracker = new Tracker();

		 String name1 = "First task";
		 String description1 = "First description";
		 String comment1 = "First comment";

		 String name2 = "Second task";
		 String description2 = "Second description";
		 String comment2 = "Second comment";


		 String[] answer = {"1", name1, description1, comment1, "n", "1", name2, description2, comment2, "y"};
		 StubInput stubInput = new StubInput(answer);
		 new StartUI(stubInput, tracker).init();
		 Item[] testItem = new Item[1];
		 testItem[0] = tracker.findByName(name1);

		 String[] answerForFindById = {"4", testItem[0].getId(), "y"};
		 stubInput = new StubInput(answerForFindById);
		 new StartUI(stubInput, tracker).init();

		 assertThat(stubInput.getOut().split(", ") [0], containsString("First task"));
	 }




	 /**
	* Test checking method search task by Name;
	*/
	@Test
	public void FindByNameTask() throws Exception{
		Tracker tracker = new Tracker();
		
		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		String[] answer = {"1", name, description, comment, "n", "5", name, "y"};
		StubInput stubInput = new StubInput(answer);
		StartUI startUi = new StartUI(stubInput, tracker);
		
		startUi.init();
	
		assertThat(stubInput.getOut().split(", ") [0], is("Test task"));
	}
	
	
	/**
	* Test checking method add comment to task;
	*/
	@Test
	public void AddCommentToTask() throws Exception{
		Tracker tracker = new Tracker();

		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";

		String[] answer = {"1", name, description, "", "y"};
		StubInput stubInput = new StubInput(answer);
		new StartUI(stubInput, tracker).init();

		Item[] itemTest = new Item[1];
		itemTest[0] = tracker.findByName(name);

		String[] answerForDel = {"6", itemTest[0].getId(), comment, "n", "2", "y"};
		stubInput = new StubInput(answerForDel);
		new StartUI(stubInput, tracker).init();

		assertThat(stubInput.getOut(), containsString("Test comment"));
	}
	
	
	/**
	* Test checking method delete task;
	*/
	@Test
	public void DeleteTask() throws Exception{
		Tracker tracker = new Tracker();

		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		
		String[] answer = {"1", name, description, comment, "y"};
		StubInput stubInput = new StubInput(answer);
		new StartUI(stubInput, tracker).init();

		Item[] itemForDel = new Item[1];
		itemForDel[0] = tracker.findByName(name);

		String[] answerForDel = {"7", itemForDel[0].getId(), "y", "y"};
		stubInput = new StubInput(answerForDel);
		new StartUI(stubInput, tracker).init();
		
		assertNull(tracker.findById(itemForDel[0].getId()));
	}
}