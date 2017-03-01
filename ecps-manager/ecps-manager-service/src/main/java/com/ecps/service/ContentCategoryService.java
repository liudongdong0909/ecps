package com.ecps.service;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.model.TbContentCategory;
import com.ecps.service.base.BaseService;

import java.util.List;

/**
 * 内容分类管理Service
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-01 下午 03:10
 */
public interface ContentCategoryService extends BaseService<TbContentCategory> {

    List<EasyUITreeNode> queryContentCatList(Long parentId);

    ECPSResult insertCategory(Long parentId, String name);
}
