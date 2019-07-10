import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ToDoList {
	private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
	}
	
	public void setTask (Task oldTask, Task newTask) {
		tasks.remove(oldTask.getDescription());
		addTask(newTask);
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
	
	public List<Task> sortByDescriptionAsc(){
		Set<String> descList = this.tasks.keySet();
		String[] stringArray = (String[]) descList.toArray();
		Arrays.sort(stringArray);
		List<Task> taskList = new ArrayList<Task>();
		for (String string : stringArray) {
			for (Task task : tasks.values()) {
				if(task.getDescription().equals(string)) {
					taskList.add(task);
				}
			}
		}
		return taskList;
	}

	public List<Task> sortByDescriptionDesc(){
		List<Task> taskList = this.sortByDescriptionAsc();
		Collections.reverse(taskList);
		return taskList;
	}
	public List<Task> sortByComplete(){
		List<Task> taskList = new ArrayList<Task>();
		for (Task task : tasks.values()) {
			if(task.isComplete()) {
				taskList.add(task);
			}
		}
		for (Task task : tasks.values()) {
			if(!task.isComplete()) {
				taskList.add(task);
			}
		}
		return taskList;
		
	}
	
	public List<Task> sortByIncomplete(){
		List<Task> taskList = new ArrayList<Task>();
		for (Task task : tasks.values()) {
			if(!task.isComplete()) {
				taskList.add(task);
			}
		}
		for (Task task : tasks.values()) {
			if(task.isComplete()) {
				taskList.add(task);
			}
		}
		return taskList;
	}
	
}
