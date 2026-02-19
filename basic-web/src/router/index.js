import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ApiTestView from '../views/ApiTestView.vue'

const routes = [
    { path: '/', name: 'home', component: HomeView },
    { path: '/api-test', name: 'api-test', component: ApiTestView }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router
