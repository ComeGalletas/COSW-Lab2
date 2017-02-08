package edu.eci.cosw.spademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
@RequestMapping("/app/tasks")
public class TaskController{

    @Autowired
    private TaskManager taskPersistence;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> registrerNewTask (@RequestBody Task newTask) {
        ResponseEntity a;
        try {
            a = new ResponseEntity<>(taskPersistence.addNewTask(newTask), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            a = new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public ResponseEntity<?> getTask (@PathVariable("user") String user) {
        ResponseEntity a;
        try {
            a = new ResponseEntity<>(taskPersistence.getTask(user), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            a = new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getTasks () {
        ResponseEntity a;
        try {
            a = new ResponseEntity<>(taskPersistence.getTasks(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TaskController.class.getName()).log(Level.SEVERE, null, ex);
            a = new ResponseEntity<>("Error bla bla bla",HttpStatus.NOT_FOUND);
        }
        return a;
    }

}
