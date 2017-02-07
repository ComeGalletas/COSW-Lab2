package edu.eci.cosw.spademo;

import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by juanpa_507 on 1/02/17.
 */
@Service
public class TaskMemoryPersistence implements TaskPersistenceInterface {

    private HashMap<String, Task> tasks = new HashMap<>();

    @Override
    public Task addNewTask(String description, int priority) {
        return tasks.put(description, new Task(description, priority));
    }

    @Override
    public Task addNewTask(Task task) {
        return tasks.put(task.getDescription(), task);
    }

    @Override
    public Task getTask(String description) {
        return tasks.get(description);
    }

    @Override
    public Task[] getTasks() {
        return (Task[])tasks.values().toArray();
    }
}
