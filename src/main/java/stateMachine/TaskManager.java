package stateMachine;

import java.util.HashMap;

public class TaskManager {
    private HashMap<Integer, TaskInterface> tasks;

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void addTask(TaskInterface task) {
        tasks.put(task.getId(), task);
    }

    public TaskInterface getTaskById(Integer id) {
        return tasks.get(id);
    }
}
