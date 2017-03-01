package com.ecps.service.impl;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.model.TbContentCategory;
import com.ecps.service.ContentCategoryService;
import com.ecps.service.base.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 内容分类管理ServiceImpl
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-01 下午 03:11
 */
@Service
public class ContentCategoryServiceImpl extends BaseServiceImpl<TbContentCategory> implements ContentCategoryService {

    @Override
    public List<EasyUITreeNode> queryContentCatList(Long parentId) {

        TbContentCategory contentCat = new TbContentCategory();
        contentCat.setParentId(parentId);
        List<TbContentCategory> contentCategories = super.mapper.select(contentCat);

        List<EasyUITreeNode> treeNodes = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(contentCategories)) {
            swithEasyUITreeNode(contentCategories, treeNodes);
        }
        return treeNodes;
    }

    @Override
    public ECPSResult insertCategory(Long parentId, String name) {

        TbContentCategory contentCategory = new TbContentCategory();
        contentCategory.setParentId(parentId);
        contentCategory.setName(name);
        contentCategory.setStatus(1);
        contentCategory.setIsParent(false);
        //'排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数'
        contentCategory.setSortOrder(1);

        this.mapper.insert(contentCategory);

        Long id = contentCategory.getId();

        //更新id等于parentId的节点为父节点
        TbContentCategory contentCategory2 = new TbContentCategory();
        contentCategory2.setId(parentId);
        contentCategory2.setIsParent(true);
        contentCategory2.setUpdated(contentCategory.getCreated());

        this.mapper.updateByPrimaryKeySelective(contentCategory2);

        return ECPSResult.success(id);
    }

    private void swithEasyUITreeNode(List<TbContentCategory> contentCategories, List<EasyUITreeNode> treeNodes) {
        EasyUITreeNode treeNode;
        for (TbContentCategory content : contentCategories) {
            treeNode = new EasyUITreeNode();
            treeNode.setId(content.getId());
            treeNode.setText(content.getName());
            treeNode.setState(content.getIsParent() ? "closed" : "open");
            treeNodes.add(treeNode);
        }
    }
}
