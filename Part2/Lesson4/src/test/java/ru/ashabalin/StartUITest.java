import ru.ashabalin.models.*;
import ru.ashabalin.start.*;
import java.util.*;
import java.io.PrintStream;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringContains.containsString;

 /**
 * Created by Aleksei Shabalin.
 */

public class StartUITest{
	
	/**
	* Test checking method add task;
	*/
	@Test
	public void addTask() throws Exception{
		
		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		String[] answer = {"1", name, description, comment, "n", "2", "y"};
		StubInput stubInput = new StubInput(answer);
		StartUI startUi = new StartUI(stubInput);
		
		startUi.init();
	
		assertNotNull(stubInput.getOut());
	}
	
	/**
	* Test checking method edit task;
	*/
	
	
	/**
	* Test checking method search task by ID;
	*/
	// @Test
	// public void FindByIdTask() throws Exception{
		
	// }
	
	
	/**
	* Test checking method search task by Name;
	*/
	@Test
	public void FindByNameTask() throws Exception{
		
		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		String[] answer = {"1", name, description, comment, "n", "5", name, "y"};
		StubInput stubInput = new StubInput(answer);
		StartUI startUi = new StartUI(stubInput);
		
		startUi.init();
	
		assertThat(stubInput.getOut().split(", ") [0], is("Test task"));
	}
	
	
	/**
	* Test checking method add comment to task;
	*/
	
	
	/**
	* Test checking method delete task;
	*/
	@Test
	public void deleteTask() throws Exception{
		Tracker tracker = new Tracker();
		Item item = tracker.add(new Item());
		String id = item.getId();
		
		String name = "Test task";
		String description = "Test description";
		String comment = "Test comment";
		
		
		String[] answer = {"1", name, description, comment, "n", "2", "n", "7", id, "y", "y"};
		StubInput stubInput = new StubInput(answer);
		StartUI startUi = new StartUI(stubInput);		
		
		startUi.init();
		
		assertNull(stubInput.getOut());
	}
}