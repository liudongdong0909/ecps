package com.ecps.service.impl;

import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.model.TbItemCat;
import com.ecps.service.ItemCatService;
import com.ecps.service.base.impl.BaseServiceImpl;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品分类管理serviceImpl
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-27 上午 09:58
 */
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<TbItemCat> implements ItemCatService {

   /* @Autowired
    private TbItemCatMapper itemCatMapper;*/

    @Override
    public  List<EasyUITreeNode> queryItemCatList(Long parentId) {
        TbItemCat itemCat = new TbItemCat();
        itemCat.setParentId(parentId);

        List<TbItemCat> itemCats = super.mapper.select(itemCat);

        List<EasyUITreeNode> result = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(itemCats)) {
            switchEasyUITreeNode(itemCats, result);
        }
        return result;
    }

    private void switchEasyUITreeNode(List<TbItemCat> itemCats, List<EasyUITreeNode> result) {
        EasyUITreeNode treeNode;
        for (TbItemCat itemCat : itemCats){
            treeNode = new EasyUITreeNode();
            treeNode.setId(itemCat.getId());
            treeNode.setText(itemCat.getName());
            treeNode.setState(itemCat.getIsParent() ? "closed" : "open");
            result.add(treeNode);
        }
    }
}
