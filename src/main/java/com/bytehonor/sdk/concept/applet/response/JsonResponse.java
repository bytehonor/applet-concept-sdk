package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;

import com.bytehonor.sdk.concept.applet.code.StandardCode;
import com.bytehonor.sdk.concept.applet.exception.ResponseException;

/**
 * 统一的 JSON 响应模型。
 * <p>约定使用 {@link com.bytehonor.sdk.concept.applet.code.StandardCode#OK} 表示成功，
 * 其余 code 由业务或框架语义定义。</p>
 *
 * @author lijianqiang
 *
 * @param <T> 响应体数据类型
 */
public final class JsonResponse<T> implements Serializable {

    private static final long serialVersionUID = 2464992888381774481L;

    private Integer code;

    private String message;

    private T data;

    /**
     * 返回携带字符串结果的成功响应。
     *
     * @param data 业务结果
     * @return 成功响应
     */
    public static JsonResponse<DataString> ok(String data) {
        return success(DataString.of(data));
    }

    /**
     * 返回携带整数结果的成功响应。
     *
     * @param data 业务结果
     * @return 成功响应
     */
    public static JsonResponse<DataInteger> ok(Integer data) {
        return success(DataInteger.of(data));
    }

    /**
     * 返回携带长整数结果的成功响应。
     *
     * @param data 业务结果
     * @return 成功响应
     */
    public static JsonResponse<DataLong> ok(Long data) {
        return success(DataLong.of(data));
    }

    /**
     * 返回携带布尔结果的成功响应。
     *
     * @param data 业务结果
     * @return 成功响应
     */
    public static JsonResponse<DataBoolean> ok(Boolean data) {
        return success(DataBoolean.of(data));
    }

    /**
     * 构建响应对象的统一入口。
     *
     * @param code 响应码
     * @param message 响应信息
     * @param data 响应数据
     * @param <R> 数据类型
     * @return 响应对象
     */
    public static <R> JsonResponse<R> build(int code, String message, R data) {
        JsonResponse<R> result = new JsonResponse<R>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 构建成功响应。
     *
     * @param data 响应数据
     * @param <R> 数据类型
     * @return 成功响应
     */
    public static <R> JsonResponse<R> success(R data) {
        return build(StandardCode.OK, StandardCode.SUCCESS, data);
    }

    /**
     * 构建失败响应（不携带 data）。
     *
     * @param code 失败码
     * @param message 失败信息
     * @param <R> 数据类型
     * @return 失败响应
     */
    public static <R> JsonResponse<R> error(int code, String message) {
        return build(code, message, null);
    }

    /**
     * 安全提取响应数据。
     * <p>校验顺序固定为：响应对象非空 -> 响应码为 OK -> data 非空。
     * 任一条件不满足都会抛出 {@link ResponseException}。</p>
     *
     * @param response 待解析响应
     * @param <T> 数据类型
     * @return data 字段
     */
    public static <T> T safeGet(JsonResponse<T> response) {
        if (response == null) {
            throw new ResponseException("RESPONSE NULL");
        }
        if (response.getCode() != StandardCode.OK) {
            throw new ResponseException(response.toString());
        }
        T data = response.getData();
        if (data == null) {
            throw new ResponseException("RESPONSE BODY NULL");
        }
        return data;
    }

    /**
     * 从响应中提取字符串结果。
     *
     * @param response 待解析响应
     * @return 字符串结果
     */
    public static String dataString(JsonResponse<DataString> response) {
        DataString ds = safeGet(response);
        return ds.getResult();
    }

    /**
     * 从响应中提取长整数结果。
     *
     * @param response 待解析响应
     * @return 长整数结果
     */
    public static Long dataLong(JsonResponse<DataLong> response) {
        DataLong data = safeGet(response);
        return data.getResult();
    }

    /**
     * 从响应中提取整数结果。
     *
     * @param response 待解析响应
     * @return 整数结果
     */
    public static Integer dataInteger(JsonResponse<DataInteger> response) {
        DataInteger data = safeGet(response);
        return data.getResult();
    }

    /**
     * 从响应中提取布尔结果。
     *
     * @param response 待解析响应
     * @return 布尔结果
     */
    public static Boolean dataBoolean(JsonResponse<DataBoolean> response) {
        DataBoolean data = safeGet(response);
        return data.getResult();
    }

    /**
     * 判断响应是否为失败状态。
     *
     * @param response 响应对象
     * @param <T> 数据类型
     * @return 为 null 或 code 非 OK 时返回 true
     */
    public static <T> boolean isError(JsonResponse<T> response) {
        if (response == null) {
            return true;
        }
        return response.getCode() != StandardCode.OK;
    }

    /**
     * 构建远程调用降级响应，不携带数据。
     *
     * @param <S> 数据类型
     * @return 降级响应
     */
    public static <S> JsonResponse<S> fallback() {
        return fallback(null);
    }

    /**
     * 构建远程调用降级响应。
     * <p>该方法固定使用 {@link StandardCode#FEIGN_FALLBACK}，
     * 用于表达上游服务不可用场景。</p>
     *
     * @param data 降级返回数据
     * @param <S> 数据类型
     * @return 降级响应
     */
    public static <S> JsonResponse<S> fallback(S data) {
        JsonResponse<S> result = new JsonResponse<S>();
        result.setCode(StandardCode.FEIGN_FALLBACK);
        result.setMessage("远程服务不可用");
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[code:").append(this.code).append(", message:").append(this.message).append("]");
        return sb.toString();
    }

}
