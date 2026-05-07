package com.bytehonor.sdk.concept.applet.exception;

/**
 * 框架层运行时异常。
 * <p>用于表示基础设施或框架处理过程中的异常情况。</p>
 *
 * @author lijianqiang
 */
public class FrameworkException extends RuntimeException {

    private static final long serialVersionUID = -1480130710794334949L;

    public FrameworkException() {
        super();
    }

    public FrameworkException(String message) {
        super(message);
    }

    public FrameworkException(String message, Throwable cause) {
        super(message, cause);
    }
}
