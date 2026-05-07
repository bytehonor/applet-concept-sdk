package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

/**
 * 整数结果包装对象。
 *
 * @author lijianqiang
 *
 */
public class DataInteger implements Serializable {

    private static final long serialVersionUID = -3592186356812066966L;

    private Integer result;

    /**
     * 构建整数结果对象。
     *
     * @param result 结果值
     * @return 结果对象
     */
    public static DataInteger of(Integer result) {
        return new DataInteger(result);
    }

    public DataInteger(Integer result) {
        this.result = result;
    }

    public DataInteger() {
        this(null);
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

}
