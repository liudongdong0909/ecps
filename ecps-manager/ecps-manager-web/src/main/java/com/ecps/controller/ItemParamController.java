package com.ecps.controller;

import com.ecps.common.bean.ECPSResult;
import com.ecps.model.TbItemParam;
import com.ecps.service.ItemParamService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品参数模板管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-01 下午 01:36
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    private static final Logger logger = LoggerFactory.getLogger(ItemParamController.class);

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping(value = "/query/itemcatid/{cid}", method = RequestMethod.GET)
    @ResponseBody
    public ECPSResult getItemParaByCid(@PathVariable Long cid) {
        try {
            TbItemParam itemParam = new TbItemParam();
            itemParam.setItemCatId(cid);
            List<TbItemParam> paramItems = itemParamService.queryListByWhere(itemParam);
            if (CollectionUtils.isNotEmpty(paramItems)){
                if (logger.isInfoEnabled()){
                    logger.info("获取分类下的商品模板参数: cid= {}", cid);
                }
                return ECPSResult.success(paramItems.get(0));
            }
            return ECPSResult.success();
        } catch (Exception e) {
            logger.error("获取分类下的商品参数模板失败: cid= {}", cid, e);
        }
        return ECPSResult.error();
    }

}
