import { defineStore } from 'pinia'
import { ref } from 'vue'
import axios from 'axios'

export const useAppStore = defineStore('app', () => {
    const healthStatus = ref(null)
    const sampleData = ref(null)
    const loading = ref(false)
    const error = ref(null)

    async function fetchHealth() {
        loading.value = true
        error.value = null
        try {
            const response = await axios.get('/api/health')
            healthStatus.value = response.data
        } catch (err) {
            error.value = err.message
        } finally {
            loading.value = false
        }
    }

    async function fetchSample() {
        loading.value = true
        error.value = null
        try {
            const response = await axios.get('/api/sample')
            sampleData.value = response.data
        } catch (err) {
            error.value = err.message
        } finally {
            loading.value = false
        }
    }

    return { healthStatus, sampleData, loading, error, fetchHealth, fetchSample }
})
