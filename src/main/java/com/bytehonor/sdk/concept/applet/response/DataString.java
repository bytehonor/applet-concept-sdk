package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

import com.bytehonor.sdk.concept.applet.code.StandardCode;

/**
 * 字符串结果包装对象。
 *
 * @author lijianqiang
 *
 */
public class DataString implements Serializable {

    private static final long serialVersionUID = -2026720210560037542L;

    private String result;

    /**
     * 构建默认成功字符串结果（success）。
     *
     * @return 默认结果对象
     */
    public static DataString ok() {
        return new DataString();
    }

    /**
     * 构建指定字符串结果对象。
     *
     * @param result 结果值
     * @return 结果对象
     */
    public static DataString of(String result) {
        return new DataString(result);
    }

    public DataString(String result) {
        this.result = result;
    }

    public DataString() {
        this(StandardCode.SUCCESS);
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
