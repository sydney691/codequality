package com.codequality.sample.sydneyzamoranos.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codequality.sample.sydneyzamoranos.todo.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity,Integer>  {
}
