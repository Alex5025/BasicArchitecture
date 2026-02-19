# Pre-commit 本地開發環境設置 (SETUP)

本份文件說明如何在 **地端開發環境** 安裝與配置 pre-commit，確保程式碼提交前自動執行格式檢查與 Checkstyle.

## 1. 安裝 Pre-commit 工具

macOS 使用 Homebrew 安裝：

```bash
brew install pre-commit
```

驗證安裝：

```bash
pre-commit --version
```

## 2. 專案初始化

在專案根目錄 (`BasicArchitecture/`) 執行以下指令，將 git hooks 安裝到 `.git/hooks` 目錄：

```bash
pre-commit install
```

成功訊息範例：
> pre-commit installed at .git/hooks/pre-commit

## 3. 設定檔說明 (.pre-commit-config.yaml)

專案已預先設定好 `.pre-commit-config.yaml`，包含：

- **基本檢查**：移除尾端空白、修正檔案結尾換行、YAML 格式檢查.
- **Java 格式化**：使用 `google-java-format` (AOSP 風格).
- **Checkstyle**：執行 `mvn checkstyle:check` 進行程式碼風格檢查 (Google Style).

## 4. 首次執行 / 手動執行

建議在開始開發前，先對所有檔案執行一次檢查：

```bash
pre-commit run --all-files
```

這會自動修正部分格式問題（如 Java 排版），並回報無法自動修正的錯誤.

## 5. 常見問題

### Q: `mvn checkstyle:check` 執行很久？
A: 這是因為每次 commit 都會啟動 Maven.若只修改少量檔案，Maven 啟動時間佔比較高.

### Q: 如何暫時略過檢查？
A: 緊急情況下（不建議），可使用 `--no-verify` (或 `-n`)：
```bash
git commit -m "wip" --no-verify
```
