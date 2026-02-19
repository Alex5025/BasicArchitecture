package org.inariforge.scheduler.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Quartz Job 實作：發送 HTTP 請求（模擬 Cloud Scheduler）.
 */
@Slf4j
public class HttpJob implements Job {

    public static final String URL = "url";
    public static final String METHOD = "method";
    public static final String PAYLOAD = "payload";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        String url = dataMap.getString(URL);
        String methodStr = dataMap.getString(METHOD);
        String payload = dataMap.getString(PAYLOAD);

        log.info("執行 Quartz HTTP Job: {} {}", methodStr, url);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<String> entity = new HttpEntity<>(payload, headers);
            HttpMethod method = HttpMethod.valueOf(methodStr != null ? methodStr : "POST");

            ResponseEntity<String> response = restTemplate
                    .exchange(url, method, entity, String.class);

            log.info("Job 執行結果: {} - {}", response.getStatusCode(), response.getBody());
        } catch (Exception e) {
            log.error("Job 執行失敗: {}", e.getMessage(), e);
            throw new JobExecutionException(e);
        }
    }
}
