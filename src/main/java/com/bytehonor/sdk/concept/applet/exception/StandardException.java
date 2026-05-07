package com.bytehonor.sdk.concept.applet.exception;

/**
 * 带标准错误码的运行时异常。
 * <p>适用于需要向上层明确返回业务/框架错误码的场景。</p>
 *
 * @author lijianqiang
 *
 */
public class StandardException extends RuntimeException {

    private static final long serialVersionUID = -183184291876365329L;

    /**
     * 错误码，建议与 StandardCode 约定保持一致。
     */
    private int code;

    public StandardException() {
        super();
    }

    /**
     * 构建带错误码的异常。
     *
     * @param code 错误码
     * @param message 错误信息
     */
    public StandardException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
