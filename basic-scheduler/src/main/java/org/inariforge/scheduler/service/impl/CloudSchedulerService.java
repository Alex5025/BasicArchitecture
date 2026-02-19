package org.inariforge.scheduler.service.impl;

import com.google.cloud.scheduler.v1.CloudSchedulerClient;
import com.google.cloud.scheduler.v1.HttpMethod;
import com.google.cloud.scheduler.v1.HttpTarget;
import com.google.cloud.scheduler.v1.Job;
import com.google.cloud.scheduler.v1.JobName;
import com.google.cloud.scheduler.v1.LocationName;
import com.google.protobuf.ByteString;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.inariforge.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * GCP Cloud Scheduler 排程服務實作（雲端環境）.
 */
@Slf4j
@Service
@Profile("cloudrun")
public class CloudSchedulerService implements SchedulerService {

    @Value("${gcp.project-id:}")
    private String projectId;

    @Value("${gcp.location:asia-east1}")
    private String location;

    @Value("${gcp.scheduler.handler-url:}")
    private String handlerUrl;

    @Override
    public void createJob(String jobName, String cronExpression,
                          String payload) {
        try (CloudSchedulerClient client = CloudSchedulerClient.create()) {
            LocationName parent = LocationName.of(projectId, location);

            HttpTarget httpTarget = HttpTarget.newBuilder()
                    .setUri(handlerUrl + "/" + jobName)
                    .setHttpMethod(HttpMethod.POST)
                    .setBody(ByteString.copyFromUtf8(payload))
                    .putHeaders("Content-Type", "application/json")
                    .build();

            Job job = Job.newBuilder()
                    .setName(JobName.of(projectId, location, jobName)
                            .toString())
                    .setSchedule(cronExpression)
                    .setTimeZone("Asia/Taipei")
                    .setHttpTarget(httpTarget)
                    .build();

            Job createdJob = client.createJob(parent, job);
            log.info("Cloud Scheduler 排程已建立: {}", createdJob.getName());
        } catch (IOException e) {
            log.error("建立 Cloud Scheduler 排程失敗: {}", jobName, e);
            throw new RuntimeException("建立排程失敗", e);
        }
    }

    @Override
    public void deleteJob(String jobName) {
        try (CloudSchedulerClient client = CloudSchedulerClient.create()) {
            JobName name = JobName.of(projectId, location, jobName);
            client.deleteJob(name);
            log.info("Cloud Scheduler 排程已刪除: {}", jobName);
        } catch (IOException e) {
            log.error("刪除 Cloud Scheduler 排程失敗: {}", jobName, e);
            throw new RuntimeException("刪除排程失敗", e);
        }
    }

    @Override
    public void pauseJob(String jobName) {
        try (CloudSchedulerClient client = CloudSchedulerClient.create()) {
            JobName name = JobName.of(projectId, location, jobName);
            client.pauseJob(name);
            log.info("Cloud Scheduler 排程已暫停: {}", jobName);
        } catch (IOException e) {
            log.error("暫停 Cloud Scheduler 排程失敗: {}", jobName, e);
            throw new RuntimeException("暫停排程失敗", e);
        }
    }

    @Override
    public void resumeJob(String jobName) {
        try (CloudSchedulerClient client = CloudSchedulerClient.create()) {
            JobName name = JobName.of(projectId, location, jobName);
            client.resumeJob(name);
            log.info("Cloud Scheduler 排程已恢復: {}", jobName);
        } catch (IOException e) {
            log.error("恢復 Cloud Scheduler 排程失敗: {}", jobName, e);
            throw new RuntimeException("恢復排程失敗", e);
        }
    }
}
