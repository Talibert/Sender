package com.example.sender.service;

import com.example.sender.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitSenderService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.MY_QUEUE, mensagem);
    }
}
