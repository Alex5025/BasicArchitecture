package org.inariforge.queue.service;

/**
 * 佇列服務介面 — 統一的訊息佇列操作抽象.
 * 本地環境使用 RabbitMQ，雲端環境使用 GCP Cloud Tasks.
 */
public interface QueueService {

    void sendMessage(String queueName, String payload);

    void sendDelayedMessage(String queueName, String payload, long delaySeconds);
}
