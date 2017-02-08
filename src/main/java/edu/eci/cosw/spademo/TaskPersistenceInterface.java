package edu.eci.cosw.spademo;

import java.util.List;

/**
 * Created by juanpa_507 on 1/02/17.
 */
public interface TaskPersistenceInterface {

    Task addNewTask(String user, String description, int priority);
    Task addNewTask(Task task);

    Task getTask(String user);
    List<Task> getTasks();

}
