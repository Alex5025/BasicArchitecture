# basic-queue 模組設定

## 用途
訊息佇列抽象層，透過 Spring `@Profile` 切換本地與雲端實作.

## 架構

```
QueueService（介面）
├── RabbitMqQueueService    @Profile("local")     → RabbitMQ
└── CloudTaskQueueService   @Profile("cloudrun")  → GCP Cloud Tasks
```

## API

| 方法 | 說明 |
|------|------|
| `sendMessage(queueName, payload)` | 發送訊息 |
| `sendDelayedMessage(queueName, payload, delaySeconds)` | 發送延遲訊息 |

## 本地設定（RabbitMQ）

在 `application-local.yml`：
```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

管理介面：http://localhost:15672

## 雲端設定（GCP Cloud Tasks）

在 `application-cloudrun.yml`：
```yaml
gcp:
  project-id: ${GCP_PROJECT_ID}
  location: asia-east1
  cloud-tasks:
    handler-url: ${CLOUD_TASKS_HANDLER_URL}
```

## 如何使用

```java
@Autowired
private QueueService queueService;

queueService.sendMessage("my-queue", "{\"key\": \"value\"}");
```
