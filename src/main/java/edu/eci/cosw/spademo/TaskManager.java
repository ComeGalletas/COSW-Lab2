package edu.eci.cosw.spademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by juanpa_507 on 1/02/17.
 */
@Service
public class TaskManager {

    @Autowired
    private TaskPersistenceInterface taskPersistence;


    public Task addNewTask(String description, int priority){
        return taskPersistence.addNewTask(description, priority);
    }

    public Task addNewTask(Task newTask){
        return taskPersistence.addNewTask(newTask);
    }

    public Task getTask(String description){
        return taskPersistence.getTask(description);
    }

    public List<Task> getTasks(){
        return taskPersistence.getTasks();
    }


}
