# Quartz 資料表欄位說明

本文件詳細說明 `basic-scheduler` 模組中 Quartz 使⽤的完整資料表結構 (共 11 張表)。

這些資料表通常由 Spring Boot Quartz Starter 自動初始化，或透過 SQL script 建立。

## 1. 核心任務與觸發器

### 1.1 QRTZ_JOB_DETAILS
儲存 **任務 (Job)** 的靜態定義與屬性。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `JOB_NAME` | VARCHAR(200) | **(PK)** 任務名稱 |
| `JOB_GROUP` | VARCHAR(200) | **(PK)** 任務群組 |
| `DESCRIPTION` | VARCHAR(250) | 任務描述 |
| `JOB_CLASS_NAME` | VARCHAR(250) | 任務執行類別的全名 |
| `IS_DURABLE` | BOOLEAN | 是否持久化 (無 Trigger 是否保留) |
| `IS_NONCONCURRENT` | BOOLEAN | 是否禁止並發執行 |
| `IS_UPDATE_DATA` | BOOLEAN | 是否更新 JobData |
| `REQUESTS_RECOVERY` | BOOLEAN | 是否要求故障恢復 (重啟後重跑) |
| `JOB_DATA` | BLOB | 任務參數序列化資料 |

### 1.2 QRTZ_TRIGGERS
儲存 **觸發器 (Trigger)** 的基礎資訊與狀態。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_NAME` | VARCHAR(200) | **(PK)** 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 觸發器群組 |
| `JOB_NAME` | VARCHAR(200) | **(FK)** 關聯的任務名稱 |
| `JOB_GROUP` | VARCHAR(200) | **(FK)** 關聯的任務群組 |
| `DESCRIPTION` | VARCHAR(250) | 觸發器描述 |
| `NEXT_FIRE_TIME` | BIGINT | 下次觸發時間 (Epoch ms) |
| `PREV_FIRE_TIME` | BIGINT | 上次觸發時間 (Epoch ms) |
| `PRIORITY` | INTEGER | 優先級 |
| `TRIGGER_STATE` | VARCHAR(16) | 狀態 (`WAITING`, `PAUSED`, `ACQUIRED`, `EXECUTING`, `ERROR`, `BLOCKED`) |
| `TRIGGER_TYPE` | VARCHAR(8) | 類型 (`CRON`, `SIMPLE`, `BLOB`, `CAL_INT`) |
| `START_TIME` | BIGINT | 開始時間 |
| `END_TIME` | BIGINT | 結束時間 |
| `CALENDAR_NAME` | VARCHAR(200) | 關聯行事曆名稱 |
| `MISFIRE_INSTR` | SMALLINT | Misfire 策略代碼 |
| `JOB_DATA` | BLOB | 觸發器參數資料 |

## 2. 觸發器類型詳細資訊

### 2.1 QRTZ_SIMPLE_TRIGGERS
儲存 **Simple Trigger** (固定間隔/次數) 的詳細設定。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_NAME` | VARCHAR(200) | **(PK)** 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 觸發器群組 |
| `REPEAT_COUNT` | BIGINT | 重複次數 (-1 為無限) |
| `REPEAT_INTERVAL` | BIGINT | 重複間隔 (ms) |
| `TIMES_TRIGGERED` | BIGINT | 已觸發次數 |

### 2.2 QRTZ_CRON_TRIGGERS
儲存 **Cron Trigger** (Cron 表達式) 的詳細設定。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_NAME` | VARCHAR(200) | **(PK)** 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 觸發器群組 |
| `CRON_EXPRESSION` | VARCHAR(120) | Cron 表達式 |
| `TIME_ZONE_ID` | VARCHAR(80) | 時區 ID |

### 2.3 QRTZ_SIMPROP_TRIGGERS
儲存 **Calendar Interval Trigger** 或 **Daily Time Interval Trigger** 屬性。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_NAME` | VARCHAR(200) | **(PK)** 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 觸發器群組 |
| `STR_PROP_1` | VARCHAR(512) | 字串屬性 1 |
| `STR_PROP_2` | VARCHAR(512) | 字串屬性 2 |
| `STR_PROP_3` | VARCHAR(512) | 字串屬性 3 |
| `INT_PROP_1` | INTEGER | 整數屬性 1 |
| `INT_PROP_2` | INTEGER | 整數屬性 2 |
| `LONG_PROP_1` | BIGINT | 長整數屬性 1 |
| `LONG_PROP_2` | BIGINT | 長整數屬性 2 |
| `DEC_PROP_1` | NUMERIC | 十進位屬性 1 |
| `DEC_PROP_2` | NUMERIC | 十進位屬性 2 |
| `BOOL_PROP_1` | BOOLEAN | 布林屬性 1 |
| `BOOL_PROP_2` | BOOLEAN | 布林屬性 2 |

### 2.4 QRTZ_BLOB_TRIGGERS
儲存自訂觸發器類型的序列化資料 (較少用)。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_NAME` | VARCHAR(200) | **(PK)** 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 觸發器群組 |
| `BLOB_DATA` | BLOB | 自訂觸發器資料 |

## 3. 系統狀態與管理

### 3.1 QRTZ_CALENDARS
儲存 Quartz 行事曆 (用於排除特定時間，如國定假日)。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `CALENDAR_NAME` | VARCHAR(200) | **(PK)** 行事曆名稱 |
| `CALENDAR` | BLOB | 序列化的行事曆物件 |

### 3.2 QRTZ_PAUSED_TRIGGER_GRPS
儲存已暫停的觸發器群組。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | **(PK)** 暫停的群組名稱 |

### 3.3 QRTZ_FIRED_TRIGGERS
儲存 **正在執行中** 的觸發器資訊 (執行完畢後通常會刪除)。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `ENTRY_ID` | VARCHAR(95) | **(PK)** 執行實例 ID |
| `TRIGGER_NAME` | VARCHAR(200) | 觸發器名稱 |
| `TRIGGER_GROUP` | VARCHAR(200) | 觸發器群組 |
| `INSTANCE_NAME` | VARCHAR(200) | 觸發執行的實例名稱 |
| `FIRED_TIME` | BIGINT | 實際觸發時間 |
| `SCHED_TIME` | BIGINT | 預定觸發時間 |
| `PRIORITY` | INTEGER | 優先級 |
| `STATE` | VARCHAR(16) | 狀態 (`EXECUTING`, `ACQUIRED`, `WAITING`...) |
| `JOB_NAME` | VARCHAR(200) | 任務名稱 |
| `JOB_GROUP` | VARCHAR(200) | 任務群組 |
| `IS_NONCONCURRENT` | BOOLEAN | 是否非並發 |
| `REQUESTS_RECOVERY` | BOOLEAN | 是否要求恢復 |

### 3.4 QRTZ_SCHEDULER_STATE
儲存叢集 (Cluster) 中各個 Scheduler 實例的狀態 (用於 Heartbeat)。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `INSTANCE_NAME` | VARCHAR(200) | **(PK)** 實例 ID |
| `LAST_CHECKIN_TIME` | BIGINT | 上次 Heartbeat 時間 |
| `CHECKIN_INTERVAL` | BIGINT | Heartbeat 間隔 (ms) |

### 3.5 QRTZ_LOCKS
儲存用於叢集環境下的 Pessimistic Locks (悲觀鎖)。

| 欄位名稱 | 類型 | 說明 |
| :--- | :--- | :--- |
| `SCHED_NAME` | VARCHAR(120) | **(PK)** 排程器名稱 |
| `LOCK_NAME` | VARCHAR(40) | **(PK)** 鎖名稱 (如 `TRIGGER_ACCESS`, `JOB_ACCESS`) |

