package org.inariforge.scheduler.service;

/**
 * 排程服務介面 — 統一的排程操作抽象.
 * 本地環境使用 Spring Quartz，雲端環境使用 GCP Cloud Scheduler.
 */
public interface SchedulerService {

    /**
     * 建立排程任務.
     *
     * @param jobName     任務名稱
     * @param cronExpression Cron 運算式
     * @param payload     任務資料（JSON 字串）
     */
    void createJob(String jobName, String cronExpression, String payload);

    /**
     * 刪除排程任務.
     *
     * @param jobName 任務名稱
     */
    void deleteJob(String jobName);

    /**
     * 暫停排程任務.
     *
     * @param jobName 任務名稱
     */
    void pauseJob(String jobName);

    /**
     * 恢復排程任務.
     *
     * @param jobName 任務名稱
     */
    void resumeJob(String jobName);
}
