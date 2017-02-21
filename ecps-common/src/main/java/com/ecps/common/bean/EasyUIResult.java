package com.ecps.common.bean;

import java.util.List;

/**
 * 封装EasyUI分页结果
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 01:54
 */
public class EasyUIResult {

    private Long total;

    private List<?> rows;

    public EasyUIResult() {
    }

    public EasyUIResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyUIResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
