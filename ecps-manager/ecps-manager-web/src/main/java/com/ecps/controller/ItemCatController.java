package com.ecps.controller;

import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.service.ItemCatService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//import org.springframework.stereotype.Controller;

/**
 * 商品分类管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-27 上午 11:25
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

    private static final Logger logger = LoggerFactory.getLogger(ItemCatController.class);

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "list", method = RequestMethod.POST)
    private ResponseEntity<List<EasyUITreeNode>> queryItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        try {
            List<EasyUITreeNode> treeNodes = itemCatService.queryItemCatList(parentId);
            if (CollectionUtils.isNotEmpty(treeNodes)) {
                return ResponseEntity.ok(treeNodes);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            logger.error("商品分类树查询失败: parentId= {}", parentId);
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

}
