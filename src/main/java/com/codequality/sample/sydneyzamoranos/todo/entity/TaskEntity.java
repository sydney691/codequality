package com.codequality.sample.sydneyzamoranos.todo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Entity
@Data
@Builder
public class TaskEntity {
  @Id
  private Integer id;
  private String name;
  private String description;
  
  @Tolerate
  public TaskEntity() {
    
  }
}
