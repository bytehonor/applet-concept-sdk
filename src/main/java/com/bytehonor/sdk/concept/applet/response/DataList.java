package com.bytehonor.sdk.concept.applet.response;

import java.io.Serializable;
import java.util.List;

/**
 * 列表数据包装对象，通常用于分页或批量返回场景。
 *
 * @author lijianqiang
 *
 * @param <T> 列表元素类型
 */
public class DataList<T> implements Serializable {

    private static final long serialVersionUID = -3569067658999958726L;

    private Integer total;

    private List<T> list;

    /**
     * 根据列表内容创建包装对象，total 默认等于列表长度。
     *
     * @param list 列表数据
     * @param <T> 列表元素类型
     * @return 包装对象
     */
    public static <T> DataList<T> of(List<T> list) {
        return of(list, list != null ? list.size() : 0);
    }

    /**
     * 根据列表和总数创建包装对象。
     * <p>total 可用于分页总记录数，不要求与 list.size() 相等。</p>
     *
     * @param list 当前页数据
     * @param total 总记录数
     * @param <T> 列表元素类型
     * @return 包装对象
     */
    public static <T> DataList<T> of(List<T> list, Integer total) {
        DataList<T> vo = new DataList<T>();
        vo.setList(list);
        vo.setTotal(total);
        return vo;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
