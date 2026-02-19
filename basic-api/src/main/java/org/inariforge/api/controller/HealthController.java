package org.inariforge.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.LocalDateTime;
import java.util.Map;
import org.inariforge.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康檢查 Controller（Cloud Run 需要）.
 */
@RestController
@RequestMapping("/api/health")
@Tag(name = "健康檢查", description = "應用程式健康狀態端點")
public class HealthController {

    /**
     * 健康檢查.
     *
     * @return 健康狀態
     */
    @GetMapping
    @Operation(summary = "健康檢查", description = "回傳應用程式目前狀態")
    public ApiResponse<Map<String, Object>> health() {
        Map<String, Object> data = Map.of(
                "status", "UP",
                "timestamp", LocalDateTime.now().toString()
        );
        return ApiResponse.success(data);
    }
}
