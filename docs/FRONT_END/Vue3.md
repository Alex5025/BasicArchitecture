# Vue 3 設定說明

## 版本

| 套件 | 版本 |
|------|------|
| Vue | 3.4.x |
| Pinia | 2.1.x |
| Vue Router | 4.3.x |
| Axios | 1.6.x |
| Vite | 5.2.x |

## 專案位置
獨立資料夾，不透過 Maven 管理：
```
basic-web/
```

## 安裝與啟動

```bash
cd basic-web
npm install
npm run dev       # 開發伺服器 http://localhost:3000
npm run build     # 建置生產版本 → dist/
```

## 結構

| 目錄 | 說明 |
|------|------|
| `src/views/` | 頁面元件 |
| `src/router/` | Vue Router 路由設定 |
| `src/stores/` | Pinia Store（狀態管理） |
| `src/assets/` | CSS / 靜態資源 |

## API 代理
`vite.config.js` 將 `/api` 請求代理至後端 `http://localhost:8080`.

## 相關文件
- [Vue 3 官方文件](https://vuejs.org/)
- [Pinia 官方文件](https://pinia.vuejs.org/)
- [Vite 官方文件](https://vitejs.dev/)
