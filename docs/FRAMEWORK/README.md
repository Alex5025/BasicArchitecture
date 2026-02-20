# 框架與模組介紹 (Frameworks & Modules)

本目錄包含專案使用的技術框架與模組架構說明.

## 核心技術 (Core Technologies)

- **[Spring Boot](SPRING_BOOT.md)**: 應用程式核心框架
- **[SpringDoc OpenAPI](SPRINGDOC_OPENAPI.md)**: API 文件自動生成
- **[MapStruct](MAPSTRUCT.md)**: Object Mapping 工具
- **[Vue 3](../FRONT_END/README.md)**: 前端框架 (Pinia, Vue Router)

## 模組說明 (Modules)

關於各個後端模組的職責，請參閱 [docs/MODULES/README.md](../MODULES/README.md).

## 排程系統 (Quartz Scheduling)

本專案使用 Quartz 進行排程，詳細資料表結構說明如下：

- **[Quartz 概覽](QUARTZ.md)**: 核心資料表與 JPA Entity 映射
- **[核心任務與觸發器](quartz_core.md)**: `QRTZ_JOB_DETAILS`, `QRTZ_TRIGGERS`
- **[觸發器類型詳細資訊](quartz_triggers.md)**: `QRTZ_CRON_TRIGGERS`, `QRTZ_SIMPLE_TRIGGERS` 等
- **[系統狀態與管理](quartz_system.md)**: `QRTZ_LOCKS`, `QRTZ_SCHEDULER_STATE` 等
- **[完整資料表欄位對照](QUARTZ_TABLES.md)**: 11 張表的詳細欄位說明
