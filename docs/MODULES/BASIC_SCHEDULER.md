# basic-scheduler 模組設定

## 用途
排程抽象層，透過 Spring `@Profile` 切換本地與雲端實作.

## 架構

```
SchedulerService（介面）
├── QuartzSchedulerService    @Profile("local")     → Spring Quartz
└── CloudSchedulerService     @Profile("cloudrun")  → GCP Cloud Scheduler
```

## API

| 方法 | 說明 |
|------|------|
| `createJob(jobName, cron, payload)` | 建立排程 |
| `deleteJob(jobName)` | 刪除排程 |
| `pauseJob(jobName)` | 暫停排程 |
| `resumeJob(jobName)` | 恢復排程 |

## 本地設定（Quartz）

在 `application-local.yml`：
```yaml
spring:
  quartz:
    job-store-type: memory
    properties:
      org.quartz.threadPool.threadCount: 5
```

## 雲端設定（GCP Scheduler）

在 `application-cloudrun.yml`：
```yaml
gcp:
  project-id: ${GCP_PROJECT_ID}
  location: asia-east1
  scheduler:
    handler-url: ${CLOUD_SCHEDULER_HANDLER_URL}
```

## 如何使用

```java
@Autowired
private SchedulerService schedulerService;

schedulerService.createJob("daily-report", "0 0 8 * * ?", "{\"type\": \"report\"}");
```
