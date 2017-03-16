package com.ecps.api.controller;


import com.ecps.api.service.ItemCatService;
import com.ecps.common.bean.ItemCatResult;
import com.ecps.common.util.ECPSJsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 对外提供商品分类接口
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-02 上午 10:27
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ItemCategoryController.class);

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 提供商品分类树查询功能 API
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ItemCatResult queryItemCategoryList() {
        try {
            ItemCatResult itemCatResult = this.itemCatService.queryItemcatList();
            return itemCatResult;
        } catch (Exception e) {
            logger.error("使用 API 获取商品分类树失败:", e);
        }
        return null;
    }

    /**
     * 提供商品分类树查询功能 API2
     *
     * @return
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> queryItemCategoryList(@RequestParam(value = "callback", required = false) String callback) {
        try {
            ItemCatResult itemCatResult = this.itemCatService.queryItemcatList();
            if (itemCatResult == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            String result = ECPSJsonUtil.objectToJson(itemCatResult);

            if (StringUtils.isEmpty(callback)) {
                return ResponseEntity.ok(result);
            }else {
                StringBuffer buffer = new StringBuffer();
                buffer.append(callback).append("(").append(result).append(")");
                return ResponseEntity.ok(buffer.toString());
            }

        } catch (Exception e) {
            logger.error("使用 API 获取商品分类树失败:", e);
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

}
