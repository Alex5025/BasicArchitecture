<template>
  <div class="home">
    <h1>BasicArchitecture</h1>
    <p>模組化全端應用程式</p>
    <div class="card-grid">
      <div class="card">
        <h3>🔧 後端</h3>
        <p>Spring Boot 3 + PostgreSQL</p>
      </div>
      <div class="card">
        <h3>🖥️ 前端</h3>
        <p>Vue 3 + Pinia + Vite</p>
      </div>
      <div class="card">
        <h3>📨 佇列</h3>
        <p>RabbitMQ / GCP Tasks</p>
      </div>
      <div class="card">
        <h3>⏰ 排程</h3>
        <p>Quartz / GCP Scheduler</p>
      </div>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped>
.home {
  text-align: center;
  padding: 2rem 0;
}

.home h1 {
  font-size: 2.5rem;
  color: #e94560;
}

.card-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
  gap: 1.5rem;
  margin-top: 2rem;
}

.card {
  background: #16213e;
  border-radius: 12px;
  padding: 1.5rem;
  color: #fff;
  transition: transform 0.2s;
}

.card:hover {
  transform: translateY(-4px);
}

.card h3 {
  margin-bottom: 0.5rem;
}
</style>
