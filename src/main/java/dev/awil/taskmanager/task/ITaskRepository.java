package dev.awil.taskmanager.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Long>{
    
}
