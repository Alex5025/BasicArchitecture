package org.inariforge.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 統一 API 回應格式.
 *
 * @param <T> 回應資料類型
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .code(200)
                .message("success")
                .data(data)
                .build();
    }

    public static ApiResponse<Void> success() {
        return ApiResponse.<Void>builder()
                .code(200)
                .message("success")
                .build();
    }

    public static ApiResponse<Void> error(int code, String message) {
        return ApiResponse.<Void>builder()
                .code(code)
                .message(message)
                .build();
    }

    public static <T> ApiResponse<T> error(org.inariforge.common.enums.ReturnCode returnCode) {
        return ApiResponse.<T>builder()
                .code(returnCode.getCode())
                .message(returnCode.getMessage())
                .build();
    }
}
