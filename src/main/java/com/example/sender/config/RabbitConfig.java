package com.example.sender.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classe responsável por criar os Beans de cada fila e registrar no contexto Spring
 * O Spring AMQP cria a fila no RabbitMQ assim que a aplicação sobe
 *
 * Portanto, basta chamar os métodos do rabbit utilizando as filas declaradas
 */
@Configuration
public class RabbitConfig {

    public static final String REQUEST_QUEUE = "request-queue";
    public static final String RESPONSE_QUEUE = "response-queue";

    @Bean
    public Queue requestQueue() {
        return new Queue(REQUEST_QUEUE, true);
    }

    @Bean
    public Queue responseQueue() {
        return new Queue(RESPONSE_QUEUE, true);
    }
}
