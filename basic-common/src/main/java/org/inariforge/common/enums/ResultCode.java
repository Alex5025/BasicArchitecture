package org.inariforge.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用回應碼 Enum.
 */
@Getter
@AllArgsConstructor
public enum ResultCode implements ReturnCode {

    SUCCESS(200, "Success"),
    FAILURE(400, "Failure"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),

    // GCP 相關錯誤
    GCP_ERROR(5001, "GCP Service Error"),
    GCP_TIMEOUT(5002, "GCP Service Timeout"),
    GCP_RESOURCE_NOT_FOUND(5003, "GCP Resource Not Found"),
    GCP_UNAUTHORIZED(5004, "GCP Unauthorized");

    private final int code;
    private final String message;
}
