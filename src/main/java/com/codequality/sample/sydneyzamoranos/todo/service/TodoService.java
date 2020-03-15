package com.codequality.sample.sydneyzamoranos.todo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codequality.sample.sydneyzamoranos.todo.entity.TaskEntity;
import com.codequality.sample.sydneyzamoranos.todo.pojo.TaskPojo;
import com.codequality.sample.sydneyzamoranos.todo.repository.TaskRepository;

@Service
public class TodoService {
  
  @Autowired
  private TaskRepository taskRepository;
  
  public List<TaskEntity> getTasks() {
    return taskRepository.findAll();
  }
  
  public TaskEntity saveOrUpdateTask(TaskEntity taskEntity) {
    return taskRepository.save(taskEntity);
  }
  
  public void deleteTask(int id) {
    taskRepository.deleteById(id);
  }
  
  public TaskEntity transformToEntity(TaskPojo todoTask) {
    
    return transformData(todoTask);
  }

  private TaskEntity transformData(TaskPojo todoTask) {
    TaskEntity task = TaskEntity
                      .builder()
                      .name(todoTask.getName())
                      .description(todoTask.getDescription())
                      .isDone(todoTask.isDone())
                      .build();
    
    return task;
  }
  
}
