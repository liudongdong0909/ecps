package com.ecps.api.service;

import com.ecps.api.service.base.BaseService;
import com.ecps.common.bean.ItemCatResult;
import com.ecps.model.TbItemCat;

/**
 * 商品分类Service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-02 上午 11:54
 */
public interface ItemCatService extends BaseService<TbItemCat> {

    /**
     * 获取商品分类树所有节点，提供给portal工程使用
     *
     * @return
     */
    ItemCatResult queryItemcatList();
}
