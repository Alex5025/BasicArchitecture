# basic-queue

訊息佇列模組，透過 Spring Profile 切換本地與雲端實作.

## 架構

```
QueueService（介面）
├── RabbitMqQueueService   @Profile("local")     — RabbitMQ
└── CloudTaskQueueService  @Profile("cloudrun")   — GCP Cloud Tasks
```

## API

| 方法 | 說明 |
|------|------|
| `sendMessage(queueName, payload)` | 發送訊息 |
| `sendDelayedMessage(queueName, payload, delaySeconds)` | 發送延遲訊息 |
