package com.swedbank.StudentApplication.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository  extends JpaRepository<Task, Long> {
    List<Task> findByGroupId(Long groupId);
}
