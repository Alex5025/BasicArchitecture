# Vue Router 路由管理

本專案使用 [Vue Router 4](https://router.vuejs.org/) 進行單頁應用程式 (SPA) 的路由管理。

## 設定

路由設定檔位於 `src/router/index.js`。

```javascript
import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    }
  ]
})

export default router
```

## 使用方式

*   **`<RouterView />`**: 顯示目前路由對應的元件。
*   **`<RouterLink to="...">`**: 建立導航連結。

```vue
<template>
  <nav>
    <RouterLink to="/">Home</RouterLink>
    <RouterLink to="/about">About</RouterLink>
  </nav>
  <RouterView />
</template>
```
