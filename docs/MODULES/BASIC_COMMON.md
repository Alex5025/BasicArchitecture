# basic-common 模組設定

## 用途
提供所有後端模組共享的基礎元件.

## 套件結構

| 套件 | 說明 |
|------|------|
| `org.inariforge.common.entity` | JPA Entity 基底類（`BaseEntity`） |
| `org.inariforge.common.dto` | 通用 DTO（`ApiResponse`） |
| `org.inariforge.common.mapper` | MapStruct Mapper 介面 |
| `org.inariforge.common.exception` | 統一例外處理 |
| `org.inariforge.common.util` | 工具類（`DateUtils`） |

## 主要依賴

| 依賴 | 用途 |
|------|------|
| Spring Data JPA | Entity 定義 |
| Jackson | JSON 序列化 |
| Lombok | 樣板程式碼簡化 |
| MapStruct | Entity ↔ DTO 映射 |
| Jakarta Validation | 欄位驗證 |

## 如何擴充
1. 新增 Entity → `entity/` 套件，繼承 `BaseEntity`
2. 新增 DTO → `dto/` 套件
3. 新增 Mapper → `mapper/` 套件，實作 `@Mapper` 介面
4. 新增工具類 → `util/` 套件
