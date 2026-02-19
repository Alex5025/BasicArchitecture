package org.inariforge.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.inariforge.common.dto.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 範例 Controller — 展示基本 CRUD 架構.
 */
@RestController
@RequestMapping("/api/sample")
@Tag(name = "範例", description = "範例 CRUD API")
public class SampleController {

    /**
     * 取得範例資料.
     *
     * @return 範例字串
     */
    @GetMapping
    @Operation(summary = "取得範例", description = "回傳範例資料")
    public ApiResponse<String> getSample() {
        return ApiResponse.success("Hello from BasicArchitecture!");
    }

    @GetMapping("/error")
    @Operation(summary = "測試錯誤", description = "測試 BusinessException (ResultCode.FAILURE)")
    public ApiResponse<String> testError() {
        throw new org.inariforge.common.exception.BusinessException(
                org.inariforge.common.enums.ResultCode.FAILURE);
    }
}
