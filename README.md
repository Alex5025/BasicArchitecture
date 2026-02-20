# 模組化全端應用程式 (Modular Full-Stack Application)

這是一個基於 Spring Boot 和 Vue 3 的模組化全端應用程式架構。

## 文件導引 (Documentation)

- **[系統架構說明 (System Architecture)](docs/ARCHITECTURE.md)**  
  介紹專案整體設計、模組相依關係與技術棧（含 Nginx）。

- **[業務流程指引 (Business Flow Guide)](docs/GUIDES/BUSINESS_FLOW.md)**  
  說明排程設定、批次啟動與各組件間的作業流程。

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
