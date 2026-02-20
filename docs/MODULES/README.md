# 專案模組說明 (Project Modules)

關於整體設計概覽，請參閱 [系統架構說明](../ARCHITECTURE.md).

本專案採用 Maven 多模組架構，各模組職責如下：

## [基礎通用模組 (basic-common)](BASIC_COMMON.md)
包含所有模組共用的 Entity, DTO, Enums (ReturnCode), Exceptions (BusinessException), 以及工具類 (Utilities)。

## [API 服務模組 (basic-api)](BASIC_API.md)
主要的 Spring Boot 後端應用程式。負責處理 REST API 請求，整合其他模組服務。
- **Controller Layer**: 處理 HTTP 請求
- **Service Layer**: 業務邏輯
- **Repository Layer**: 資料庫存取

## [訊息佇列模組 (basic-queue)](BASIC_QUEUE.md)
負責非同步訊息處理。
- **Local**: RabbitMQ
- **Cloud**: GCP Cloud Tasks

## [排程任務模組 (basic-scheduler)](BASIC_SCHEDULER.md)
負責排程任務管理。
- **Local**: Spring Quartz
- **Cloud**: GCP Cloud Scheduler
