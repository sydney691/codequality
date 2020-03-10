package com.codequality.sample.sydneyzamoranos.todo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.codequality.sample.sydneyzamoranos.demo.DemoApplication;
import com.codequality.sample.sydneyzamoranos.todo.entity.TaskEntity;
import com.codequality.sample.sydneyzamoranos.todo.repository.TaskRepository;

@SpringBootTest(classes = DemoApplication.class)
public class TodoServiceTest {
  
  @Autowired 
  private TodoService todoService;
  
  @Autowired
  private TaskRepository taskRepository;
  
  @BeforeEach 
  public void createTodoDatainDb() {
    TaskEntity taskEntity = new TaskEntity();
    taskEntity.setDescription("Sample task");
    taskEntity.setDone(false);
    
    taskRepository.save(taskEntity);
  }
  
  @Test
  public void testGetTasks() {
    List<TaskEntity> tasks = todoService.getTasks();
    TaskEntity taskEntity = tasks.get(0);
    
    assertEquals("Sample task", taskEntity.getDescription());
    assertFalse(taskEntity.isDone());
  }
  
  //Inserting more tests here
  
}
