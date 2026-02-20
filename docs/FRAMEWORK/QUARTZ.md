# Quartz 排程模組說明

本文件詳細說明 Quartz 在系統中的資料庫結構與 Entity 映射。

## 資料表結構 (Schema)

Quartz 使用 11 張標準資料表來儲存排程資訊，主要使用的有：

*   `qrtz_job_details`: 儲存任務定義 (JobDetail)
*   `qrtz_triggers`: 儲存觸發器基本資訊 (Trigger)
*   `qrtz_cron_triggers`: 儲存 Cron 表達式 (CronTrigger)

### 實體關係圖 (ER Model)

```mermaid
erDiagram
    QrtzJobDetail ||--o{ QrtzTrigger : "'1' has many 'N'"
    QrtzTrigger ||--o{ QrtzCronTrigger : "'1' is a '0..1'"
    QrtzTrigger ||--o{ QrtzSimpleTrigger : "'1' is a '0..1'"

    QrtzJobDetail {
        varchar sched_name PK "排程器名稱 (預設: quartzScheduler)"
        varchar job_name PK "任務名稱"
        varchar job_group PK "任務群組 (預設: DEFAULT)"
        varchar job_class_name "任務執行類別"
        boolean is_durable "是否持久化 (無 Trigger 是否保留)"
        bytea job_data "任務參數 (Serialized Map)"
    }

    QrtzTrigger {
        varchar sched_name PK "排程器名稱"
        varchar trigger_name PK "觸發器名稱"
        varchar trigger_group PK "觸發器群組"
        varchar job_name FK "關聯任務名稱"
        varchar job_group FK "關聯任務群組"
        bigint next_fire_time "下次執行時間 (Epoch ms)"
        varchar trigger_state "狀態 (WAITING, ACQUIRED, EXECUTING, PAUSED, ERROR)"
    }

    QrtzCronTrigger {
        varchar sched_name PK "排程器名稱"
        varchar trigger_name PK "觸發器名稱"
        varchar trigger_group PK "觸發器群組"
        varchar cron_expression "Cron 表達式"
        varchar time_zone_id "時區 (所有模組統一 Asia/Taipei)"
    }
```

## JPA Entity 說明

位於 `org.inariforge.scheduler.entity.quartz` 套件。

> **注意**：所有 Quartz Entity 皆標註 `@Immutable`，僅供查詢使用，禁止透過 JPA 修改。請一律透過 `SchedulerService` 操作排程。

### 1. QrtzJobDetail
任務定義檔。對應 `qrtz_job_details` 表。

### 2. QrtzTrigger
觸發器基礎資訊。對應 `qrtz_triggers` 表。
*   `triggerState` 欄位可查詢任務目前狀態 (e.g. `PAUSED`, `WAITING`)。

### 3. QrtzCronTrigger
Cron 觸發器專用資訊。對應 `qrtz_cron_triggers` 表。
*   可查詢 `cronExpression`。
