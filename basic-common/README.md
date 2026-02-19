# basic-common

共用模組，提供所有後端模組共享的基礎元件.

## 內容

| 套件 | 說明 |
|------|------|
| `entity` | JPA Entity 基底類（`BaseEntity`：ID + 審計欄位） |
| `dto` | 通用 DTO（`ApiResponse`：統一 API 回應格式） |
| `mapper` | MapStruct Mapper 介面（Entity ↔ DTO 轉換） |
| `exception` | 統一例外處理（`BusinessException` + `GlobalExceptionHandler`） |
| `util` | 工具類（`DateUtils`：Asia/Taipei 時區） |

## 依賴

- Spring Data JPA、Jackson、Lombok、MapStruct、Jakarta Validation
