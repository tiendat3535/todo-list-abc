package com.pyco.coreapplication.endpoint;

import com.pyco.coreapplication.doimain.Task;
import com.pyco.coreapplication.dto.TaskCriteria;
import com.pyco.coreapplication.dto.TaskDto;
import com.pyco.coreapplication.mapper.TaskDtoMapper;
import com.pyco.coreapplication.mapper.TaskMapper;
import com.pyco.coreapplication.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("v1/private")
public class TaskEndpoint {

    @Autowired
    private TaskService taskService;

    @GetMapping("todos")
    public Page<Task> getTodos(Pageable pageable,
                               @RequestParam(value = "content", required = false) String content,
                               @RequestParam(value = "startDate", required = false) LocalDate startDate,
                               @RequestParam(value = "endDate", required = false) LocalDate endDate) {
        return taskService.findAllTasksOfPerson(new TaskCriteria(content, startDate, endDate), pageable);
    }

    @PostMapping("todos")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskDto createTodo(@Validated @RequestBody TaskDto taskDto) {
        Task task = TaskDtoMapper.INSTANCE.toTask(taskDto);
        return TaskMapper.INSTANCE.toTaskDto(taskService.createTask(task));
    }

    @PutMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public TaskDto updateTodo(@Validated @RequestBody TaskDto taskDto) {
        Task task = TaskDtoMapper.INSTANCE.toTask(taskDto);
        return TaskMapper.INSTANCE.toTaskDto(taskService.updateTask(task));
    }

    @DeleteMapping("todos/{taskId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable("taskId") String taskId) {
        taskService.deleteTask(taskId);
    }
}
