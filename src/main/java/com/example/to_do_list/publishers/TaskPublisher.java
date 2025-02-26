package com.example.to_do_list.publishers;

import com.example.to_do_list.dtos.Task;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TaskPublisher {
  private final RabbitTemplate rabbitTemplate;

  @Value("${rabbitmq.queue}")
  private String queue;


  public TaskPublisher(RabbitTemplate rabbitTemplate) {
    this.rabbitTemplate = rabbitTemplate;
  }

  public Task publishTask(Task task) {
    task.setCreatedAt(LocalDateTime.now());
    task.setTitle(task.getTitle().toUpperCase());
    rabbitTemplate.convertAndSend(queue, task);
    return task;
  }
}
