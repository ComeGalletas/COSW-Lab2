package edu.eci.cosw.spademo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by juanpa_507 on 1/02/17.
 */
@Service
public class TaskMemoryPersistence implements TaskPersistenceInterface {

    private HashMap<String, Task> tasks = new HashMap<>();

    public TaskMemoryPersistence(){
        this.addNewTask("ola", 1);
        this.addNewTask("ke", 2);
        this.addNewTask("ase", 3);
    }

    @Override
    public Task addNewTask(String description, int priority) {
        Task newTask = new Task(description, priority);
        return (tasks.put(newTask.getDescription(), newTask) == null ? newTask : null);
    }

    @Override
    public Task addNewTask(Task newTask) {
        return (tasks.put(newTask.getDescription(), newTask) == null ? newTask : null);
    }

    @Override
    public Task getTask(String description) {
        return tasks.get(description);
    }

    @Override
    public List<Task> getTasks() {
        List<Task> list = new ArrayList<Task>(tasks.values());
        return list;
    }
}
