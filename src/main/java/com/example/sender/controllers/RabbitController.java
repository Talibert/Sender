package com.example.sender.controllers;

import com.example.sender.service.RabbitSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esse controller é para testes de comunicação entre os dois projetos
 */
@RestController
@RequestMapping(value = "/rabbitTest")
public class RabbitController {

    final private RabbitSenderService rabbitSenderService;

    @Autowired
    public RabbitController(RabbitSenderService rabbitSenderService){
        this.rabbitSenderService = rabbitSenderService;
    }

    @GetMapping("/send")
    public String enviar(@RequestParam String mensagem) {
        rabbitSenderService.sendMessage(mensagem);
        return "Mensagem enviada: " + mensagem;
    }
}
