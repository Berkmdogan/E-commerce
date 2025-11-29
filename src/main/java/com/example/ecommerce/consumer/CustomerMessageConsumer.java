package com.example.ecommerce.consumer;

import com.example.ecommerce.config.RabbitMQConfig;
import com.example.ecommerce.dto.CustomerDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class CustomerMessageConsumer {
    @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void handleCustomerCreation(CustomerDto customerDto) {

        System.out.println("---------------------------------------------");
        System.out.println("✅ Müşteri Kayıt Mesajı Başarıyla Alındı.");
        System.out.println("Müşteri ID: " + customerDto.getCustomerId());
        System.out.println("E-posta Adresi: " + customerDto.getEmail());
        System.out.println("Simülasyon: Hoş Geldin E-postası kuyrukta işlendi.");
        System.out.println("---------------------------------------------");
    }
}
