# Axios HTTP 客戶端

本專案使用 [Axios](https://axios-http.com/) 進行 HTTP 請求，與後端 API 進行通訊。

## 基礎使用

直接在元件中引入並使用：

```javascript
import axios from 'axios'

// GET 請求
axios.get('/api/users')
  .then(response => {
    console.log(response.data)
  })
  .catch(error => {
    console.error(error)
  })

// POST 請求
axios.post('/api/users', {
    name: 'New User',
    email: 'user@example.com'
  })
  .then(response => {
    console.log(response.data)
  })
```

## 建議實作 (Best Practice)

建議建立一個統一的 `axios` 實體 (Instance) 來管理 baseURL、攔截器 (Interceptors) 與錯誤處理。

例如建立 `src/utils/request.js`：

```javascript
import axios from 'axios'

const service = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || '/api', // 使用環境變數或預設值
  timeout: 5000
})

// 請求攔截器
service.interceptors.request.use(
  config => {
    // 可以在這裡加入 Token
    // config.headers['Authorization'] = 'Bearer ' + token
    return config
  },
  error => {
    return Promise.reject(error)
  }
)

// 回應攔截器
service.interceptors.response.use(
  response => {
    return response.data
  },
  error => {
    console.log('err' + error)
    return Promise.reject(error)
  }
)

export default service
```
