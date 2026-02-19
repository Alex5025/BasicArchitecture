package org.inariforge.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.inariforge.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 排程任務回呼處理器 (範例).
 * 這是被 Cloud Scheduler 或 Quartz Trigger 呼叫的端點.
 */
@Slf4j
@Tag(name = "Job Handlers", description = "排程回呼處理")
@RestController
@RequestMapping("/api/job-handlers")
public class JobHandlerController {

    @Operation(summary = "範例任務回呼")
    @PostMapping("/{jobName}")
    public ApiResponse<Void> handleJob(@PathVariable String jobName,
                                       @RequestBody(required = false) String payload) {
        log.info("收到任務回呼: jobName={}, payload={}", jobName, payload);
        // 在此執行實際業務邏輯
        return ApiResponse.success();
    }
}
