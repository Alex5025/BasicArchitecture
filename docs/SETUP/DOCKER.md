# Docker 設定說明

## 檔案位置
所有 Docker 檔案位於 `docker/` 資料夾.

## Docker Compose 服務

| 服務 | 映像檔 | 連接埠 |
|------|--------|--------|
| PostgreSQL | `postgres:16` | 5432 |
| RabbitMQ | `rabbitmq:3-management` | 5672, 15672 |
| API | 自建 (Dockerfile.api) | 8080 |
| Web | 自建 (Dockerfile.web) | 3000 → 80 |

## 啟動

```bash
cd docker
cp .env.example .env
docker-compose up -d
docker-compose ps
```

## Volume 位置

所有持久化資料存放於 `docker/volumes/`：

| 目錄 | 說明 |
|------|------|
| `volumes/postgres-data/` | PostgreSQL 資料 |
| `volumes/rabbitmq-data/` | RabbitMQ 資料 |
| `volumes/api-logs/` | Spring Boot 日誌 |
| `volumes/nginx-logs/` | Nginx 日誌 |

## Dockerfile 說明

| 檔案 | 用途 |
|------|------|
| `Dockerfile.api` | 後端多階段建置 (Maven → JRE) |
| `Dockerfile.web` | 前端多階段建置 (Node → Nginx) |
| `Dockerfile.api.cloudrun` | Cloud Run 最佳化 |

## 常用指令

```bash
docker-compose up -d          # 啟動
docker-compose down            # 停止
docker-compose down -v         # 停止並清除資料
docker-compose logs -f api     # 查看 API 日誌
docker-compose restart api     # 重啟 API
```
