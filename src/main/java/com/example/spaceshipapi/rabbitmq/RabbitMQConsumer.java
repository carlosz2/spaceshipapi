package com.example.spaceshipapi.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.spaceshipapi.config.RabbitMQConfig;

@Service
public class RabbitMQConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void consume(String message) {
        System.out.println("Mensaje recibido: " + message);
    }
}