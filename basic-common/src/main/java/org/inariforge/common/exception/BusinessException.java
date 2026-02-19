package org.inariforge.common.exception;

import lombok.Getter;

/**
 * 業務邏輯例外.
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final int code;

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(String message) {
        this(400, message);
    }

    public BusinessException(org.inariforge.common.enums.ReturnCode returnCode) {
        this(returnCode.getCode(), returnCode.getMessage());
    }
}
