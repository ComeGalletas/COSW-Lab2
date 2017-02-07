package edu.eci.cosw.spademo;

/**
 * Created by juanpa_507 on 1/02/17.
 */
public interface TaskPersistenceInterface {

    Task addNewTask(String description, int priority);
    Task addNewTask(Task task);

    Task getTask(String description);
    Task[] getTasks();

}
