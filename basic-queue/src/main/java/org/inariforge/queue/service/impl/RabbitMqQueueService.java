package org.inariforge.queue.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.inariforge.queue.service.QueueService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * RabbitMQ 佇列服務實作（本地環境）.
 */
@Slf4j
@Service
@Profile("local")
@RequiredArgsConstructor
public class RabbitMqQueueService implements QueueService {

    private final RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(String queueName, String payload) {
        log.info("RabbitMQ 發送訊息至 [{}]: {}", queueName, payload);
        rabbitTemplate.convertAndSend(queueName, payload);
    }

    @Override
    public void sendDelayedMessage(String queueName, String payload,
                                   long delaySeconds) {
        log.info("RabbitMQ 發送延遲訊息至 [{}], 延遲 {}s: {}",
                queueName, delaySeconds, payload);
        rabbitTemplate.convertAndSend(queueName, payload, message -> {
            message.getMessageProperties()
                    .setDelayLong(delaySeconds * 1000);
            return message;
        });
    }
}
