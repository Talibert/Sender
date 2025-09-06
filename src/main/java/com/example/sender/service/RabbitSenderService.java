package com.example.sender.service;

import com.example.sender.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service para gerenciar envio e recebimento de mensagens
 */
@Service
public class RabbitSenderService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitSenderService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * Envia a mensagem para o segundo projeto através da fila REQUES_QUEUE
     * @param mensagem
     */
    public void sendMessage(String mensagem) {
        rabbitTemplate.convertAndSend(RabbitConfig.REQUEST_QUEUE, mensagem);
    }

    /**
     * Vai assinar a fila RESPONSE_QUEUE para receber as mensagens processadas do segundo projeto
     * @param resposta
     */
    @RabbitListener(queues = RabbitConfig.RESPONSE_QUEUE)
    public void receiveResponse(String resposta) {
        System.out.println("Resposta processada pelo segundo projeto: " + resposta);
    }
}
