package com.ecps.controller;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.EasyUITreeNode;
import com.ecps.service.ContentCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-01 下午 03:06
 */
@Controller
@RequestMapping("/content/category")
public class ConentCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ConentCategoryController.class);

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public List<EasyUITreeNode> queryContentCatList(@RequestParam(value = "id", defaultValue = "0") Long parentId) {

        try {
            if (logger.isInfoEnabled()) {
                logger.info("查询内容分类: parentId= {}", parentId);
            }
            List<EasyUITreeNode> treeNodes = contentCategoryService.queryContentCatList(parentId);
            return treeNodes;
        } catch (Exception e) {
            logger.error("查询内容分类错误: parentId= {}", parentId, e);
        }
        return null;
    }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public ECPSResult insertCategory(Long parentId, String name) {
        try {

            if (logger.isInfoEnabled()) {
                logger.info("新增内容分类节点: parentId= {}, name= {}", parentId, name);
            }
            ECPSResult result = contentCategoryService.insertCategory(parentId, name);
            return result;
        } catch (Exception e) {
            logger.error("新增内容分类节点失败: parentId= {}, name= {}", parentId, name, e);
        }
        return ECPSResult.error();
    }
}