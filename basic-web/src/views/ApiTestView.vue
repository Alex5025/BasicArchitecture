<template>
  <div class="api-test">
    <h2>API 測試</h2>
    <div class="btn-group">
      <button @click="store.fetchHealth()">健康檢查</button>
      <button @click="store.fetchSample()">範例 API</button>
    </div>
    <div v-if="store.loading" class="status">載入中...</div>
    <div v-if="store.error" class="status error">錯誤: {{ store.error }}</div>
    <pre v-if="store.healthStatus" class="result">{{ JSON.stringify(store.healthStatus, null, 2) }}</pre>
    <pre v-if="store.sampleData" class="result">{{ JSON.stringify(store.sampleData, null, 2) }}</pre>
  </div>
</template>

<script setup>
import { useAppStore } from '../stores/app'

const store = useAppStore()
</script>

<style scoped>
.api-test h2 {
  color: #e94560;
}

.btn-group {
  display: flex;
  gap: 1rem;
  margin: 1rem 0;
}

button {
  padding: 0.6rem 1.2rem;
  background: #e94560;
  color: #fff;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  font-size: 1rem;
  transition: background 0.2s;
}

button:hover {
  background: #c73652;
}

.status {
  padding: 0.5rem;
  color: #aaa;
}

.status.error {
  color: #e94560;
}

.result {
  background: #16213e;
  color: #0f3460;
  padding: 1rem;
  border-radius: 8px;
  overflow-x: auto;
  color: #e2e2e2;
}
</style>
