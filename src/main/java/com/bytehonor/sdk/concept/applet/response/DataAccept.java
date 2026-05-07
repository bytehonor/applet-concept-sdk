package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

/**
 * 接收确认结果包装对象。
 * <p>server 表示处理节点，status 表示当前请求是否被接收处理。</p>
 *
 * @author lijianqiang
 *
 */
public class DataAccept implements Serializable {

    private static final long serialVersionUID = 3133545192736146299L;

    private String server;

    private Boolean status;

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
