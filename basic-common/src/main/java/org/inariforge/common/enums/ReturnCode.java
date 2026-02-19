package org.inariforge.common.enums;

/**
 * 統一回應碼介面.
 */
public interface ReturnCode {

    /**
     * 取得回應碼.
     *
     * @return 狀態碼
     */
    int getCode();

    /**
     * 取得回應訊息.
     *
     * @return 訊息
     */
    String getMessage();
}
