package com.ecps.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * ECPS系统前端工程需要商品分类数据类型
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-02 上午 10:19
 */
public class ItemCatData {

    @JsonProperty("u")
    private String url;

    @JsonProperty("n")
    private String name;

    @JsonProperty("i")
    private List<?> items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<?> getItems() {
        return items;
    }

    public void setItems(List<?> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemCatData{");
        sb.append("url='").append(url).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}
