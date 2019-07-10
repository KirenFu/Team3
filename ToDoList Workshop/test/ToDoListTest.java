import java.util.Collection;
import java.util.HashMap;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;

public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task task1;
	private ToDoList toDoList;
	
	public ToDoListTest() {
		super();
	}
	
	@Before
	 public void setUp() throws Exception{
		task1 = new Task("This is task 1");
		toDoList = new ToDoList();
	}
	
	@After
	 public void tearDown() throws Exception{
		toDoList = new ToDoList();
	}

	@Test
	public void testgetStatus() {
		task1.setComplete(true);
		toDoList.addTask(task1);
		assertTrue(toDoList.getStatus(task1.getDescription()));
		//fail("Not implemented yet");
	}
	
	@Test
	public void testRemoveTask() {
		toDoList.addTask(task1);
		assertEquals(toDoList.getTask(task1.getDescription()), task1);
		toDoList.removeTask(task1.getDescription());
		assertTrue(toDoList.getTask(task1.getDescription()) == null);
		//fail("Not implemented yet");
	}
	@Test
	public void testGetCompletedTasks() {
		task1.setComplete(true);
		toDoList.addTask(task1);
		assertTrue(toDoList.getCompletedTasks().contains(task1));
	}
	
	@Test
	public void testAddTask() {
		toDoList.addTask(task1);
		assertEquals(toDoList.getTask(task1.getDescription()), task1);
		//fail("Not implemented yet");
	}
	
	@Test
	public void testUpdateTask() {
		
		toDoList.addTask(task1);		
		Task oldTask = new Task(task1.getDescription());
		
		task1.setDescription("Update this task");		
		toDoList.setTask(oldTask, task1);
		
		assertTrue(toDoList.getTask(oldTask.getDescription()) == null);
		assertEquals(toDoList.getTask(task1.getDescription()), task1);
		//fail("Not implemented yet");
	}
}
