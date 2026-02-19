# basic-scheduler

排程模組，透過 Spring Profile 切換本地與雲端實作.

## 架構

```
SchedulerService（介面）
├── QuartzSchedulerService    @Profile("local")     — Spring Quartz
└── CloudSchedulerService     @Profile("cloudrun")   — GCP Cloud Scheduler
```

## API

| 方法 | 說明 |
|------|------|
| `createJob(jobName, cronExpression, payload)` | 建立排程 |
| `deleteJob(jobName)` | 刪除排程 |
| `pauseJob(jobName)` | 暫停排程 |
| `resumeJob(jobName)` | 恢復排程 |
