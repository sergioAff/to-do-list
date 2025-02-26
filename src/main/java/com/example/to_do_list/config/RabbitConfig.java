package com.example.to_do_list.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

  @Value("${rabbitmq.queue}")
  private String queue;

  @Bean
  public Queue queue() {
    return new Queue(queue);
  }
}
