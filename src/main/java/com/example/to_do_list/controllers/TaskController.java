package com.example.to_do_list.controllers;

import com.example.to_do_list.dtos.Task;
import com.example.to_do_list.publishers.TaskPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
  private final TaskPublisher taskPublisher;

  public TaskController(TaskPublisher taskPublisher) {
    this.taskPublisher = taskPublisher;
  }

  @PostMapping
  public Task publishTask(@RequestBody Task task) {
    return taskPublisher.publishTask(task);
  }
}
