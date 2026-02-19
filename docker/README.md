# docker

所有 Docker 相關檔案，本地開發環境透過 Docker Compose 啟動.

## 檔案

| 檔案 | 說明 |
|------|------|
| `docker-compose.yml` | 本地開發環境（PostgreSQL + RabbitMQ + API + Web） |
| `Dockerfile.api` | 後端 Spring Boot 多階段建置 |
| `Dockerfile.web` | 前端 Vue 3 多階段建置（+ Nginx） |
| `Dockerfile.api.cloudrun` | Cloud Run 最佳化映像 |
| `nginx.conf` | Nginx 設定（Vue Router + API 反向代理） |
| `.env.example` | 環境變數範本 |

## 使用方式

```bash
cd docker
cp .env.example .env
docker-compose up -d
```

## Volume 路徑

所有 Volume 資料存放於 `docker/volumes/`：

| 服務 | Volume 路徑 |
|------|------------|
| PostgreSQL | `./volumes/postgres-data` |
| RabbitMQ | `./volumes/rabbitmq-data` |
| API Logs | `./volumes/api-logs` |
| Nginx Logs | `./volumes/nginx-logs` |
