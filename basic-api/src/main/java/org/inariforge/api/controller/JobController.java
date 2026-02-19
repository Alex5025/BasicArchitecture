package org.inariforge.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.inariforge.common.dto.ApiResponse;
import org.inariforge.scheduler.service.SchedulerService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 排程管理控制器.
 */
@Tag(name = "Job Management", description = "排程任務管理")
@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final SchedulerService schedulerService;

    @Operation(summary = "建立排程任務")
    @PostMapping
    public ApiResponse<Void> createJob(@RequestBody CreateJobReq req) {
        schedulerService.createJob(req.getJobName(), req.getCron(), req.getPayload());
        return ApiResponse.success();
    }

    @Operation(summary = "刪除排程任務")
    @DeleteMapping("/{jobName}")
    public ApiResponse<Void> deleteJob(@PathVariable String jobName) {
        schedulerService.deleteJob(jobName);
        return ApiResponse.success();
    }

    @Operation(summary = "暫停排程任務")
    @PostMapping("/{jobName}/pause")
    public ApiResponse<Void> pauseJob(@PathVariable String jobName) {
        schedulerService.pauseJob(jobName);
        return ApiResponse.success();
    }

    @Operation(summary = "恢復排程任務")
    @PostMapping("/{jobName}/resume")
    public ApiResponse<Void> resumeJob(@PathVariable String jobName) {
        schedulerService.resumeJob(jobName);
        return ApiResponse.success();
    }

    @Data
    public static class CreateJobReq {
        @Schema(description = "任務名稱", example = "daily-report")
        private String jobName;

        @Schema(description = "Cron 表達式", example = "0 0 12 * * ?")
        private String cron;

        @Schema(description = "任務參數 (JSON)",
                example = "{\"targetDate\": \"2024-01-01\"}")
        private String payload;
    }
}
