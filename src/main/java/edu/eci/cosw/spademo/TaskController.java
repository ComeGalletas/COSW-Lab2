package edu.eci.cosw.spademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app/tasks")
public class TaskController{

    private TaskManager taskPersistence;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void registrerNewTask (String taskDescription, int taskPriority) {
        taskPersistence.addNewTask(taskDescription, taskPriority);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Task getTask (String taskDescription) {
        return taskPersistence.getTask(taskDescription);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Task[] getTasks () {
        return taskPersistence.getTasks();
    }

}
