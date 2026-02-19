# MapStruct 設定說明

## 版本
- MapStruct **1.5.5.Final**
- lombok-mapstruct-binding **0.2.0**

## 依賴
定義於父 POM `dependencyManagement`，各模組引用：
```xml
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
</dependency>
```

## Annotation Processor
父 POM `maven-compiler-plugin` 已設定，順序為：
1. Lombok
2. lombok-mapstruct-binding
3. MapStruct Processor

預設 `componentModel = spring`（自動注入為 Spring Bean）.

## 使用方式

```java
@Mapper
public interface SampleMapper {
    SampleDto toDto(SampleEntity entity);
    SampleEntity toEntity(SampleDto dto);
}
```

Mapper 存放位置：
```
basic-common/src/main/java/org/inariforge/common/mapper/
```

## 相關文件
- [MapStruct 官方文件](https://mapstruct.org/documentation/stable/reference/html/)
