package com.bytehonor.sdk.concept.applet.code;

/**
 * 标准响应码定义。
 * <p>该类用于约束跨模块/跨服务的统一响应语义。</p>
 *
 * @author lijianqiang
 *
 */
public class StandardCode {

    /**
     * 统一成功码。
     */
    public static final int OK = 0;

    /**
     * 统一成功信息。
     */
    public static final String SUCCESS = "success";

    /**
     * 框架层异常码（如基础设施或中间件错误）。
     */
    public static final int FRAMEWORK_ERROR = 101;

    /**
     * 服务内部错误码（非参数问题、非鉴权问题）。
     */
    public static final int INTERNAL_ERROR = 111;

    /**
     * 400 Bad Request
     */
    public static final int BAD_REQUEST = 400;

    /**
     * 401 Unauthorized
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * 403 Forbidden
     */
    public static final int FORBIDDEN = 403;

    /**
     * 404 Not Found
     */
    public static final int NOT_FOUND = 404;

    /**
     * 远程调用降级码（上游服务不可用）。
     */
    public static final int FEIGN_FALLBACK = 499;

    /**
     * 未定义错误码，用于兜底。
     */
    public static final int UNDEFINED_ERROR = 999;

    /**
     * 鉴权令牌过期错误码。
     */
    public static final int TOKEN_EXPIRED = 1001;
}
