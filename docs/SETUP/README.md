# 專案環境建置 (Project Setup)

本目錄包含啟用專案開發環境所需的工具安裝與設定.

## 前置需求
| 工具 | 最低版本 | 安裝方式 (macOS) |
|------|----------|-----------------|
| Java (JDK) | 17 | `brew install temurin17` |
| Maven | 3.9+ | `brew install maven` |
| Node.js | 20+ | `brew install node` |
| Docker | 24+ | Docker Desktop |
| Git | 2.40+ | `brew install git` |
| pre-commit | 3.0+ | `brew install pre-commit` |

## 詳細設定指南 (Setup Guides)

### 1. Pre-commit (Git Hooks)
- [PRE_COMMIT.md](PRE_COMMIT.md) — 安裝與使用說明，確保程式碼品質

### 2. Docker 環境
- [DOCKER.md](DOCKER.md) — Docker Compose 完整操作，啟動資料庫與服務

### 3. RabbitMQ
- [RABBITMQ.md](RABBITMQ.md) — 地端 RabbitMQ 啟動與管理說明

---

## 快速啟動步驟

### 1. Clone 與初始化
```bash
git clone <repo-url>
cd BasicArchitecture
pre-commit install
```

### 2. 啟動 Docker 服務
```bash
cd docker
cp .env.example .env
docker-compose up -d
```

### 3. 後端建置
```bash
mvn clean package -DskipTests
```

### 4. 前端開發
```bash
cd basic-web
npm install
npm run dev
```

## 更多資訊
關於框架介紹與模組架構，請參閱 [docs/FRAMEWORK/](../FRAMEWORK/README.md).
