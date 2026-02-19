package org.inariforge.scheduler.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.inariforge.scheduler.service.SchedulerService;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Spring Quartz 排程服務實作（本地環境）.
 */
@Slf4j
@Service
@Profile("local")
@RequiredArgsConstructor
public class QuartzSchedulerService implements SchedulerService {

    private static final String JOB_GROUP = "DEFAULT_GROUP";

    private final Scheduler scheduler;

    @Override
    public void createJob(String jobName, String cronExpression,
                          String payload) {
        try {
            JobDetail jobDetail = JobBuilder.newJob()
                    .withIdentity(jobName, JOB_GROUP)
                    .usingJobData("payload", payload)
                    .storeDurably()
                    .build();

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(jobName + "_trigger", JOB_GROUP)
                    .withSchedule(CronScheduleBuilder
                            .cronSchedule(cronExpression))
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);
            log.info("Quartz 排程已建立: {} [{}]", jobName, cronExpression);
        } catch (SchedulerException e) {
            log.error("建立 Quartz 排程失敗: {}", jobName, e);
            throw new RuntimeException("建立排程失敗", e);
        }
    }

    @Override
    public void deleteJob(String jobName) {
        try {
            scheduler.deleteJob(JobKey.jobKey(jobName, JOB_GROUP));
            log.info("Quartz 排程已刪除: {}", jobName);
        } catch (SchedulerException e) {
            log.error("刪除 Quartz 排程失敗: {}", jobName, e);
            throw new RuntimeException("刪除排程失敗", e);
        }
    }

    @Override
    public void pauseJob(String jobName) {
        try {
            scheduler.pauseJob(JobKey.jobKey(jobName, JOB_GROUP));
            log.info("Quartz 排程已暫停: {}", jobName);
        } catch (SchedulerException e) {
            log.error("暫停 Quartz 排程失敗: {}", jobName, e);
            throw new RuntimeException("暫停排程失敗", e);
        }
    }

    @Override
    public void resumeJob(String jobName) {
        try {
            scheduler.resumeJob(JobKey.jobKey(jobName, JOB_GROUP));
            log.info("Quartz 排程已恢復: {}", jobName);
        } catch (SchedulerException e) {
            log.error("恢復 Quartz 排程失敗: {}", jobName, e);
            throw new RuntimeException("恢復排程失敗", e);
        }
    }
}
