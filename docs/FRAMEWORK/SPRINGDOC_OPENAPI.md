# SpringDoc OpenAPI 設定說明

## 版本
- springdoc-openapi **2.5.0**

## 依賴
定義於 `basic-api/pom.xml`：
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
</dependency>
```

## 設定
設定類別位於：
```
basic-api/src/main/java/org/inariforge/api/config/OpenApiConfig.java
```

## 存取

| 端點 | URL |
|------|-----|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| API JSON | http://localhost:8080/v3/api-docs |

## 使用方式

在 Controller 加上 OpenAPI 註解：
```java
@Tag(name = "模組名稱", description = "說明")
@Operation(summary = "摘要", description = "詳細描述")
```

## 相關文件
- [SpringDoc 官方文件](https://springdoc.org/)
