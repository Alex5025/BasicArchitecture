# Pinia 狀態管理

本專案使用 [Pinia](https://pinia.vuejs.org/) 作為 Vue 3 的狀態管理庫。

## 快速上手

### 定義 Store

在 `src/stores/` 目錄下建立 Store 檔案，例如 `counter.js`：

```javascript
import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0)
  const doubleCount = computed(() => count.value * 2)
  function increment() {
    count.value++
  }

  return { count, doubleCount, increment }
})
```

### 在元件中使用

```vue
<script setup>
import { useCounterStore } from '@/stores/counter'

const counter = useCounterStore()
</script>

<template>
  <div>
    <p>Count: {{ counter.count }}</p>
    <p>Double: {{ counter.doubleCount }}</p>
    <button @click="counter.increment()">Increment</button>
  </div>
</template>
```
