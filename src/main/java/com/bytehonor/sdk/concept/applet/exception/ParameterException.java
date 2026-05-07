package com.bytehonor.sdk.concept.applet.exception;

/**
 * 参数校验异常。
 * <p>用于表示输入参数不符合约束的场景。</p>
 *
 * @author lijianqiang
 */
public class ParameterException extends RuntimeException {

    private static final long serialVersionUID = 4969647817957788386L;

    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
