package com.backend.email.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "email-queue")
    public void receiveEmail(@Payload String email) {
        System.out.println(email);
    }
}
