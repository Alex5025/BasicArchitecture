# basic-api 模組設定

## 用途
REST API 主服務，整合所有後端模組並提供 HTTP 端點.

## 啟動

```bash
# Maven 啟動
mvn spring-boot:run -pl basic-api

# 或透過 Docker
cd docker && docker-compose up api
```

## 端點

| 路徑 | 方法 | 說明 |
|------|------|------|
| `/api/health` | GET | 健康檢查 |
| `/api/sample` | GET | 範例 API |
| `/swagger-ui.html` | GET | Swagger UI |
| `/v3/api-docs` | GET | OpenAPI JSON |

## 設定檔

| 檔案 | 環境 |
|------|------|
| `application.yml` | 共用 |
| `application-local.yml` | 本地 Docker |
| `application-cloudrun.yml` | GCP Cloud Run |

## 依賴模組
- `basic-common` — Entity / DTO / Exception
- `basic-queue` — 佇列服務
- `basic-scheduler` — 排程服務

## 如何新增 API
1. 在 `controller/` 新增 Controller 類別
2. 加上 `@Tag` 與 `@Operation` 註解（OpenAPI）
3. 回傳 `ApiResponse<T>` 統一格式
