package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

/**
 * 长整数结果包装对象。
 *
 * @author lijianqiang
 *
 */
public class DataLong implements Serializable {

    private static final long serialVersionUID = -6318191886336616923L;

    private Long result;

    /**
     * 构建长整数结果对象。
     *
     * @param result 结果值
     * @return 结果对象
     */
    public static DataLong of(Long result) {
        return new DataLong(result);
    }

    public DataLong(Long result) {
        this.result = result;
    }

    public DataLong() {
        this(null);
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }

}
