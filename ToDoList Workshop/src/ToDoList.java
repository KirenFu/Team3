import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	public void completeTask(String description) {
		tasks.get(description).setComplete(true);
	}
	public boolean getStatus(String description) {		
		return tasks.get(description).isComplete();
	}
	public Task getTask(String description) {
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return this.tasks.values();
	}
	public List<Task> getCompletedTasks() {
		List<Task> completeListTasks = new ArrayList<Task>();
		for (Task task : tasks.values()) {
			if(task.isComplete()) {
				completeListTasks.add(task);
			}
		}
		return completeListTasks;
	}
	public List<Task> getInCompletedTasks() {
		List<Task> completeListTasks = new ArrayList<Task>();
		for (Task task : tasks.values()) {
			if(!task.isComplete()) {
				completeListTasks.add(task);
			}
		}
		return completeListTasks;
	}
	
	
}
