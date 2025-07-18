package com.backend.user.producer;

import com.backend.user.domain.dto.UserDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String queueName = "email-queue";

    @Bean
    public Queue queue() { return new Queue(queueName, true); }

    public void sendMessage(UserDto message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
