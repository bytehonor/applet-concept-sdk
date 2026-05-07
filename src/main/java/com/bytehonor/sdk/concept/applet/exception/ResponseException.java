package com.bytehonor.sdk.concept.applet.exception;

/**
 * 响应解析异常。
 * <p>用于表示响应对象为空、响应码失败或响应体缺失等不满足约定的情况。</p>
 *
 * @author lijianqiang
 */
public class ResponseException extends RuntimeException {

    private static final long serialVersionUID = -7270989851938983992L;

    public ResponseException() {
        super();
    }

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }

}
