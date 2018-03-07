package com.pyco.coreapplication.service;

import com.pyco.coreapplication.doimain.Task;
import com.pyco.coreapplication.dto.TaskCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {

    /**
     * Get all Tasks that a Person has
     * @param taskCriteria {@link TaskCriteria} including personId, content, startDate, endDate
     * @param pageable The {@link Pageable} Spring Data use to apply pagination and sorting
     * @return {@link List <Task>} that a Person has
     */
    Page<Task> findAllTasksOfPerson(TaskCriteria taskCriteria, Pageable pageable);

    /**
     * Create a new Task
     * @param task The {@link Task} person want to add into task list
     * @return created {@link Task}
     */
    Task createTask(Task task);

    /**
     * Update a Task
     * @param task The {@link Task} need to be updated
     * @return updated {@link Task}
     */
    Task updateTask(Task task);

    /**
     * Delete a Task based on its taskId
     * @param taskId
     */
    void deleteTask(String taskId);

}
