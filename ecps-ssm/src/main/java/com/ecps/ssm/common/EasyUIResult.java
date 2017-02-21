package com.ecps.ssm.common;

import java.util.List;

/**
 * EasyUI分页结果类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-14 下午 01:52
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
}
