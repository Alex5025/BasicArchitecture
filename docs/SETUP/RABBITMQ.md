# RabbitMQ 本地開發環境設置 (SETUP)

本份文件說明如何在 **地端開發環境** 透過 Docker Compose 啟動與設定 RabbitMQ，以及如何存取管理介面.

## 1. 啟動服務

RabbitMQ 已整合於專案的 `docker/docker-compose.yml` 中.請執行：

```bash
cd docker
cp .env.example .env  # 若尚未建立環境變數檔
docker-compose up -d rabbitmq
```

## 2. 驗證服務狀態

檢查容器是否正常啟動：

```bash
docker-compose ps rabbitmq
```

確認 Port 綁定：
- **5672**: 應用程式連線用 (AMQP)
- **15672**: 管理介面 (Web UI)

## 3. 存取管理介面

開啟瀏覽器存取：
- **URL**: [http://localhost:15672](http://localhost:15672)
- **預設帳號**: `guest`
- **預設密碼**: `guest`

## 4. 資料持久化

RabbitMQ 的資料（佇列、訊息、交換器設定）會持久化於地端資料夾：
- **路徑**: `docker/volumes/rabbitmq-data/`

若要**完全重置** RabbitMQ（清除所有資料）：
```bash
cd docker
docker-compose stop rabbitmq
docker-compose rm -f rabbitmq
sudo rm -rf volumes/rabbitmq-data/*  # 注意：這會刪除所有本地佇列資料
docker-compose up -d rabbitmq
```

## 5. 應用程式連線設定

後端 (`basic-api` / `basic-queue`) 在本地環境 (`profile: local`) 會讀取 `application-local.yml`：

```yaml
spring:
  rabbitmq:
    host: localhost
    port: 5672
    username: guest
    password: guest
```

若您修改了 Docker Compose 的帳密，請同步修改此檔案.
