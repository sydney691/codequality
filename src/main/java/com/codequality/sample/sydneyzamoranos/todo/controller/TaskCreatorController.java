package com.codequality.sample.sydneyzamoranos.todo.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.codequality.sample.sydneyzamoranos.todo.constant.ConstantMessageResponse;
import com.codequality.sample.sydneyzamoranos.todo.entity.TaskEntity;
import com.codequality.sample.sydneyzamoranos.todo.pojo.TaskPojo;
import com.codequality.sample.sydneyzamoranos.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TaskCreatorController {
  
  private final static Logger LOGGER = LoggerFactory.getLogger(TaskCreatorController.class);
  
  @Autowired
  private TodoService todoService;
  
  
  @GetMapping("/tasks")
  public ResponseEntity<List<TaskEntity>> listTasks() {
    
    try {
      
      return ResponseEntity.ok(todoService.getTasks());
    }catch(Exception e) {
      LOGGER.error(ConstantMessageResponse.RETRIEVING_FAILED,e);
      
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
  }
  
  @PostMapping("/task")
  public ResponseEntity<String> createTask(TaskPojo todoTask) {
    
    try {
      TaskEntity task = todoService.transformToEntity(todoTask);
      todoService.saveOrUpdateTask(task);
      
      return ResponseEntity.ok(ConstantMessageResponse.CREATION_SUCCESS);
    } catch (Exception e) {
      LOGGER.error(ConstantMessageResponse.CREATION_FAILED, e);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(ConstantMessageResponse.CREATION_FAILED);
    }
   
  }
  
  @PutMapping("/task")
  public ResponseEntity<String> updateTask(TaskPojo todoTask) {
    
    try {
      TaskEntity task = todoService.transformToEntity(todoTask);
      todoService.saveOrUpdateTask(task);
      
      return ResponseEntity.ok(ConstantMessageResponse.UPDATING_SUCCESS);
    } catch (Exception e) {
      LOGGER.error(ConstantMessageResponse.UPDATING_FAILED, e);

      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(ConstantMessageResponse.UPDATING_FAILED);
    }
   
  }
  
  @GetMapping("/task/{id}")
  public ResponseEntity<String> deleteTask(int id) {
    
    try {
      todoService.deleteTask(id);
      
      return ResponseEntity.ok(ConstantMessageResponse.DELETING_SUCCESS);
    } catch (Exception e) {
      LOGGER.error(ConstantMessageResponse.DELETING_FAILED, e);
      
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(ConstantMessageResponse.DELETING_FAILED);
    }
   
  }
  
}
