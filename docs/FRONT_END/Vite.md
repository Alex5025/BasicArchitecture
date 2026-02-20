# Vite 建置工具

本專案使用 [Vite](https://vitejs.dev/) 作為前端建置工具，提供極速的開發伺服器與優化的生產環境建置。

## 設定檔 (`vite.config.js`)

位於專案根目錄的 `basic-web/vite.config.js` 控制了 Vite 的行為。

### 重要設定

#### 1. API 代理 (Proxy)

開發環境下，為了解決跨域 (CORS) 問題，我們配置了代理伺服器，將前端 `/api` 開頭的請求轉發至後端 Spring Boot 服務。

```javascript
server: {
    port: 3000, // 前端開發伺服器埠號
    proxy: {
        '/api': {
            target: 'http://localhost:8080', // 後端 API 位址
            changeOrigin: true
        }
    }
}
```

這個設定僅在開發模式 (`npm run dev`) 有效。生產環境建置後，通常會透過 Nginx 進行反向代理配置。

#### 2. 路徑別名 (Alias)

預設配置通常包含 `@` 指向 `src` 目錄：

```javascript
resolve: {
  alias: {
    '@': fileURLToPath(new URL('./src', import.meta.url))
  }
}
```

這允許你在程式碼中使用絕對路徑引入模組，例如 `import MyComponent from '@/components/MyComponent.vue'`。

## 常用指令

*   `npm run dev`: 啟動開發伺服器 (Http://localhost:3000)
*   `npm run build`: 建置生產版本 (輸出至 `dist/`)
*   `npm run preview`: 預覽建置後的 `dist/` 內容
