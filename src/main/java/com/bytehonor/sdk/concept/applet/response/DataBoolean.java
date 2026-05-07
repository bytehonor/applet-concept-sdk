package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

/**
 * 布尔结果包装对象。
 *
 * @author lijianqiang
 *
 */
public class DataBoolean implements Serializable {

    private static final long serialVersionUID = 8002495835746801370L;

    private Boolean result;

    /**
     * 构建布尔结果对象。
     *
     * @param result 结果值
     * @return 结果对象
     */
    public static DataBoolean of(Boolean result) {
        return new DataBoolean(result);
    }

    public DataBoolean(Boolean result) {
        this.result = result;
    }

    public DataBoolean() {
        this(false);
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

}
