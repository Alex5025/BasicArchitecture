# 模組化全端應用程式 (Modular Full-Stack Application)

這是一個基於 Spring Boot 和 Vue 3 的模組化全端應用程式架構。

## 文件導引 (Documentation)

- **[環境建置與安裝 (Setup & Installation)](docs/SETUP/README.md)**  
  包含 Pre-commit、Docker、RabbitMQ 等環境準備步驟。

- **[框架與技術棧 (Framework & Tech Stack)](docs/FRAMEWORK/README.md)**  
  介紹 Spring Boot, OpenAPI, Vue 3, MapStruct 等核心技術的使用方式。

- **[專案模組說明 (Project Modules)](docs/MODULES/README.md)**  
  詳細說明 `basic-api`, `basic-common`, `basic-queue`, `basic-scheduler` 各模組的功能與職責。

## 快速開始 (Quick Start)

### 1. 啟動基礎設施 (Docker)
```bash
docker-compose -f docker/docker-compose.yml up -d
```

### 2. 建置與執行後端 (Spring Boot)
```bash
mvn clean package
java -jar basic-api/target/basic-api-0.0.1-SNAPSHOT.jar
```
API 文件: http://localhost:8080/swagger-ui.html

### 3. 執行前端 (Vue 3)
```bash
cd basic-web
npm install
npm run dev
```
前端頁面: http://localhost:3000
