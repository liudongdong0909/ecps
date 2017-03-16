package com.ecps.service;

import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.model.TbItemCat;
import com.ecps.service.base.BaseService;

import java.util.List;

/**
 * 商品分类管理Service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-27 上午 09:57
 */
public interface ItemCatService extends BaseService<TbItemCat> {

    /**
     * 获取父节点下的商品分类子节点
     *
     * @param parentId
     * @return
     */
    List<EasyUITreeNode> queryItemCatList(Long parentId);
}
