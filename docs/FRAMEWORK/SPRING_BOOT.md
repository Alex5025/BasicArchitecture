# Spring Boot 設定說明

## 版本
- Spring Boot **3.2.5**
- Java **17**

## 專案結構
主應用程式入口位於 `basic-api` 模組：
```
basic-api/src/main/java/org/inariforge/api/BasicApiApplication.java
```

## Profile 設定

| Profile | 用途 | 啟動方式 |
|---------|------|----------|
| `local` | 本地 Docker 開發 | 預設 |
| `cloudrun` | GCP Cloud Run | `SPRING_PROFILES_ACTIVE=cloudrun` |

## 設定檔

| 檔案 | 說明 |
|------|------|
| `application.yml` | 共用設定（server / JPA / SpringDoc / Actuator） |
| `application-local.yml` | 本地 PostgreSQL + RabbitMQ + Quartz |
| `application-cloudrun.yml` | Cloud SQL + GCP Tasks + GCP Scheduler |

## 相關文件
- [Spring Boot 官方文件](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
