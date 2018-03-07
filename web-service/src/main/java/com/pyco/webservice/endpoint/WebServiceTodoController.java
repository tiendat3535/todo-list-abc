package com.pyco.webservice.endpoint;

import dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("public")
public class WebServiceTodoController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("todos")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TaskDto> createTodo(@Validated @RequestBody TaskDto taskDto) {
        return restTemplate.postForEntity("/v1/private/todos", taskDto, TaskDto.class);
    }

}
