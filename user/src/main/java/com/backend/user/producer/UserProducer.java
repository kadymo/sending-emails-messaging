package com.backend.user.producer;

import com.backend.user.domain.dto.UserDto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    public UserProducer(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void sendMessage(UserDto message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
