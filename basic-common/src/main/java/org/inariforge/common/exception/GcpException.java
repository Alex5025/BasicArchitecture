package org.inariforge.common.exception;

import org.inariforge.common.enums.ResultCode;

/**
 * GCP 服務相關例外.
 */
public class GcpException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public GcpException(ResultCode resultCode) {
        super(resultCode);
    }

    public GcpException(String message) {
        super(ResultCode.GCP_ERROR.getCode(), message);
    }
}
