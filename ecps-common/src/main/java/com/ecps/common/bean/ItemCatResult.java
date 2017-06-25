package com.ecps.common.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * ECPS系统前端工程需要商品分类数据类型结果
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-02 上午 10:21
 */
public class ItemCatResult {

    @JsonProperty("data") 
    private List<ItemCatData> itemCatDatas = new ArrayList<>();

    
    
    public List<ItemCatData> getItemCatDatas() {
        return itemCatDatas;
    }

    public void setItemCatDatas(List<ItemCatData> itemCatDatas) {
        this.itemCatDatas = itemCatDatas;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ItemCatResult{");
        sb.append("itemCatDatas=").append(itemCatDatas);
        sb.append('}');
        return sb.toString();
    }
}
