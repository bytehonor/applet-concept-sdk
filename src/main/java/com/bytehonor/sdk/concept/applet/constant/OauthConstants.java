package com.bytehonor.sdk.concept.applet.constant;

/**
 * 鉴权与请求上下文相关常量。
 *
 * @author lijianqiang
 */
public class OauthConstants {

    /**
     * 免鉴权路径后缀标识。
     */
    public static final String NO_AUTH = ".do";

    /**
     * 请求来源 IP 头。
     */
    public static final String REQUEST_IP = "Request-Ip";

    /**
     * 请求唯一标识头，用于链路追踪。
     */
    public static final String REQUEST_UUID = "Request-Uuid";

    /**
     * 请求终端类型头（如 Web/Android/iOS）。
     */
    public static final String REQUEST_TERMINAL = "Request-Terminal";
}
