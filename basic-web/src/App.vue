<template>
  <div id="app">
    <nav class="navbar">
      <router-link to="/">首頁</router-link>
      <router-link to="/api-test">API 測試</router-link>
    </nav>
    <main class="container">
      <router-view />
    </main>
  </div>
</template>

<script setup>
</script>

<style scoped>
.navbar {
  display: flex;
  gap: 1rem;
  padding: 1rem 2rem;
  background: #1a1a2e;
}

.navbar a {
  color: #e94560;
  text-decoration: none;
  font-weight: 600;
}

.navbar a.router-link-active {
  color: #fff;
}

.container {
  max-width: 960px;
  margin: 2rem auto;
  padding: 0 1rem;
}
</style>
