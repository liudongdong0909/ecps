package com.ecps.api.service.impl;


import com.ecps.api.service.ItemCatService;
import com.ecps.api.service.base.impl.BaseServiceImpl;
import com.ecps.common.bean.ItemCatData;
import com.ecps.common.bean.ItemCatResult;
import com.ecps.model.TbItemCat;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品分类ServiceImpl
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-02 上午 11:54
 */
@Service
public class ItemCatServiceImpl extends BaseServiceImpl<TbItemCat> implements ItemCatService {


    /**
     * 符合portal工程的商品分类树节点
     *
     * @return
     */
    @Override
    public ItemCatResult queryItemcatList() {

        // 全部查出，并且在内存中生成树形结构
        List<TbItemCat> itemCats = super.mapper.selectAll();
        if (CollectionUtils.isEmpty(itemCats)) {
            return null;
        }

        ItemCatResult result = new ItemCatResult();

        // 转为map存储，key为父节点ID，value为数据集合
        Map<Long, List<TbItemCat>> itemCatMap = new HashMap<Long, List<TbItemCat>>();

        for (TbItemCat itemCat : itemCats) {
            if (!itemCatMap.containsKey(itemCat.getParentId())) {
                itemCatMap.put(itemCat.getParentId(), new ArrayList<TbItemCat>());
            }
            itemCatMap.get(itemCat.getParentId()).add(itemCat);
        }

       /* {
            "u": "/products/1.html",
            "n": "<a href='/products/1.html'>图书、音像、电子书刊</a>",
            "i": [
                    {
                            "u": "/products/2.html",
                            "n": "电子书刊",
                            "i": [
                                    "/products/3.html|电子书",
                                    "/products/4.html|网络原创",
                                    "/products/5.html|数字杂志",
                                    "/products/6.html|多媒体图书"
                                  ]
                    }
                ]
        }*/

        // 封装一级对象
        List<TbItemCat> itemCatList1 = itemCatMap.get(0L);
        for (TbItemCat itemCat : itemCatList1) {
            ItemCatData itemCatData = new ItemCatData();
            itemCatData.setUrl("/products/" + itemCat.getId() + ".html");
            itemCatData.setName("<a href='" + itemCatData.getUrl() + "'>" + itemCat.getName() + "</a>");
            result.getItemCatDatas().add(itemCatData);
            if (!itemCat.getIsParent()) {
                continue;
            }

            // 封装二级对象
            List<TbItemCat> itemCatList2 = itemCatMap.get(itemCat.getId());
            List<ItemCatData> itemCatData2 = new ArrayList<ItemCatData>();
            itemCatData.setItems(itemCatData2);
            for (TbItemCat itemCat2 : itemCatList2) {
                ItemCatData id2 = new ItemCatData();
                id2.setName(itemCat2.getName());
                id2.setUrl("/products/" + itemCat2.getId() + ".html");
                itemCatData2.add(id2);
                if (itemCat2.getIsParent()) {
                    // 封装三级对象
                    List<TbItemCat> itemCatList3 = itemCatMap.get(itemCat2.getId());
                    List<String> itemCatData3 = new ArrayList<String>();
                    id2.setItems(itemCatData3);
                    for (TbItemCat itemCat3 : itemCatList3) {
                        itemCatData3.add("/products/" + itemCat3.getId() + ".html|" + itemCat3.getName());
                    }
                }
            }
           /* if (result.getItemCatDatas().size() >= 14) {
                break;
            }*/
        }
        return result;
    }
}
