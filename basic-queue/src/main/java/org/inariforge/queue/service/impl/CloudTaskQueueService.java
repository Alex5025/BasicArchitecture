package org.inariforge.queue.service.impl;

import com.google.cloud.tasks.v2.CloudTasksClient;
import com.google.cloud.tasks.v2.HttpMethod;
import com.google.cloud.tasks.v2.HttpRequest;
import com.google.cloud.tasks.v2.QueueName;
import com.google.cloud.tasks.v2.Task;
import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.inariforge.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * GCP Cloud Tasks 佇列服務實作（雲端環境）.
 */
@Slf4j
@Service
@Profile("cloudrun")
public class CloudTaskQueueService implements QueueService {

    @Value("${gcp.project-id:}")
    private String projectId;

    @Value("${gcp.location:asia-east1}")
    private String location;

    @Value("${gcp.cloud-tasks.handler-url:}")
    private String handlerUrl;

    @Override
    public void sendMessage(String queueName, String payload) {
        sendDelayedMessage(queueName, payload, 0);
    }

    @Override
    public void sendDelayedMessage(String queueName, String payload,
                                   long delaySeconds) {
        log.info("Cloud Tasks 發送訊息至 [{}], 延遲 {}s: {}",
                queueName, delaySeconds, payload);
        try (CloudTasksClient client = CloudTasksClient.create()) {
            String queuePath = QueueName.of(projectId, location, queueName)
                    .toString();
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .setUrl(handlerUrl + "/" + queueName)
                    .setHttpMethod(HttpMethod.POST)
                    .setBody(ByteString.copyFromUtf8(payload))
                    .putHeaders("Content-Type", "application/json")
                    .build();
            Task.Builder taskBuilder = Task.newBuilder()
                    .setHttpRequest(httpRequest);
            if (delaySeconds > 0) {
                Instant scheduleTime = Instant.now()
                        .plusSeconds(delaySeconds);
                taskBuilder.setScheduleTime(Timestamp.newBuilder()
                        .setSeconds(scheduleTime.getEpochSecond())
                        .build());
            }
            Task task = client.createTask(queuePath, taskBuilder.build());
            log.info("Cloud Task 已建立: {}", task.getName());
        } catch (IOException e) {
            log.error("Cloud Tasks 發送失敗", e);
            throw new RuntimeException("Cloud Tasks 發送失敗", e);
        }
    }
}
