 import ru.ashabalin.models.*;
 import ru.ashabalin.start.*;
 import org.junit.Assert;
 import org.junit.Test;
 import static org.hamcrest.core.Is.is;
 
 /**
 * Created by Aleksei Shabalin.
 */
 
 public class TrackerTest{
	
	/**
	* Test checking method add task;
	*/
	
	@Test
	public void addTest() throws Exception{		
		Tracker trackerTest = new Tracker();
		Task taskTest = new Task("First", "Description First");
		trackerTest.add(taskTest);
		
		Assert.assertNotNull(trackerTest.add(taskTest));		
	}
	 
	/**
	* Test checking method search for id;
	*/
	
	@Test
	public void findByIdTest() throws Exception{
		Tracker trackerTest = new Tracker();
		Task task = new Task("Second", "Description Second");
		trackerTest.add(task);
		Task taskTest = new Task("Test", "Description Test");
		taskTest = (Task) trackerTest.findById(task.getId());
			
		Assert.assertThat(taskTest.getId(), is(task.getId()));
		Assert.assertThat(taskTest.getName(), is(task.getName()));
		Assert.assertThat(taskTest.getDescription(), is(task.getDescription()));
	}
	
	/**
	* Test checking method search for name;
	*/
	
	@Test
	public void findByNameTest() throws Exception{
		Tracker trackerTest = new Tracker();
		Task task = new Task("Third", "Description Third");
		trackerTest.add(task);
		Task taskTest = new Task("Test", "Description Test");
		taskTest = (Task) trackerTest.findByName("Third");
			
		Assert.assertThat(taskTest.getId(), is(task.getId()));
		Assert.assertThat(taskTest.getName(), is(task.getName()));
		Assert.assertThat(taskTest.getDescription(), is(task.getDescription()));
	}
	
	/**
	* Test checking method delete task;
	*/
	
	@Test
	public void delTest() throws Exception{
		Tracker trackerTest = new Tracker();
		Task taskTest = new Task("Fourth", "Description Fourth");
		trackerTest.add(taskTest);
		trackerTest.removeItem(taskTest);
		
		Assert.assertNull(trackerTest.findById(taskTest.getId()));
	}
	
	/**
	* Test checking method edit task;
	*/
	
	@Test
	public void editItemTest() throws Exception{
		Tracker trackerTest = new Tracker();
		Task task = new Task("Fifth", "Description Fifth");
		trackerTest.add(task);
		Task taskEditTest = new Task("new Fifth", " new Description Fifth");
		taskEditTest.setId(task.getId());
		trackerTest.editItem(taskEditTest);
		
		Item taskTest = trackerTest.findById(task.getId());

		Assert.assertEquals(taskTest.getName(), "new Fifth");
	}
	
	/**
	* Test checking method edit task;
	*/
	
	@Test
	public void getAllTest() throws Exception{
		Tracker trackerTest = new Tracker();
		Task task1 = new Task("Six", "Description Six");
		trackerTest.add(task1);
		Task task2 = new Task("Seven", "Description Seven");
		trackerTest.add(task2);
		
		Item[] itemsTest = new Item[2];
		itemsTest[0] = task1;
		itemsTest[1] = task2;

		Assert.assertThat(trackerTest.getAll(), is(itemsTest));
	}
 }