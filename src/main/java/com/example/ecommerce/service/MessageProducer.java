package com.example.ecommerce.service;

import com.example.ecommerce.config.RabbitMQConfig;
import com.example.ecommerce.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageProducer {
    private final RabbitTemplate rabbitTemplate; // Mesaj gönderme operasyonu

    public void sendCustomerCreationMessage(CustomerDto customerDto) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                customerDto
        );
    }
}
