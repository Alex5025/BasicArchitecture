# basic-api

REST API 主服務模組，整合所有後端模組並提供 HTTP 端點.

## 功能

- Spring Boot 3 Web 應用
- SpringDoc OpenAPI（Swagger UI：`/swagger-ui.html`）
- 健康檢查端點（`/api/health`）— Cloud Run 必要
- 範例 CRUD API（`/api/sample`）
- 全域例外處理

## 設定檔

| 檔案 | 環境 | 說明 |
|------|------|------|
| `application.yml` | 共用 | 伺服器、JPA、SpringDoc、Actuator |
| `application-local.yml` | 本地 | Docker PostgreSQL + RabbitMQ + Quartz |
| `application-cloudrun.yml` | 雲端 | Cloud SQL + GCP Tasks/Scheduler |

## 依賴模組

- `basic-common`、`basic-queue`、`basic-scheduler`
