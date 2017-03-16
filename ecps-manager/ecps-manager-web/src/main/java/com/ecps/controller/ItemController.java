package com.ecps.controller;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.EasyUIResult;
import com.ecps.common.validator.groups.Save;
import com.ecps.common.validator.groups.Update;
import com.ecps.model.TbItem;
import com.ecps.service.ItemService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 商品管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-28 下午 11:10
 */
@Controller
@RequestMapping("item")
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;
    private String desc;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryPageList(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "rows", defaultValue = "20") Integer rows) {
        try {
            PageInfo<TbItem> pageInfo = itemService.queryPageListByWhere(null, page, rows);
            return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());

        } catch (Exception e) {
            logger.error("商品分页查询失败: page= {}, rows= {}", page, rows, e);
        }
        return new EasyUIResult();
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ECPSResult createItem(@RequestBody @Validated({Save.class})  TbItem item, String desc, String itemParams) {

        try {
            if (logger.isInfoEnabled()) {
                logger.info("保存商品信息: item= {}, desc= {}, itemParams= {}", item, desc, itemParams);
            }
            return itemService.createItem(item, desc, itemParams);

        } catch (Exception e) {
            logger.error("保存商品信息失败: item= {}, desc= {}, itemParams= {}", item, desc, itemParams, e);
        }
        return ECPSResult.error();
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public ECPSResult upadteItem(@RequestBody @Validated({Update.class})  TbItem item, String desc, String itemParams) {

        try {
            if (logger.isInfoEnabled()) {
                logger.info("修改保存商品信息: item= {}, desc= {}, itemParams= {}", item, desc, itemParams);
            }
            return itemService.createItem(item, desc, itemParams);

        } catch (Exception e) {
            logger.error("修改商品信息失败: item= {}, desc= {}, itemParams= {}", item, desc, itemParams, e);
        }
        return ECPSResult.error();
    }

    @RequestMapping(value = "{itemId}", method = RequestMethod.GET)
    public ResponseEntity<TbItem> queryItemById(@PathVariable Long itemId) {
        try {
            if (logger.isInfoEnabled()) {
                logger.info("查询商品信息: itemId= {}", itemId);
            }
            TbItem item = itemService.queryById(itemId);
            if (item == null) {
                if (logger.isInfoEnabled()){
                    logger.info("商品信息不存在: itemId= {}", itemId);
                }
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            if (logger.isInfoEnabled()){
                logger.info("获取商品信息: item= {}", item);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            logger.error("查询商品信息失败: itemId= {}", itemId, e);
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }

    @RequestMapping(value = "/param/{itemId}", method =  RequestMethod.GET)
    @ResponseBody
    public String showItemParam(@PathVariable Long itemId, Model model){
        String html = itemService.getItemParamHTML(itemId);
        model.addAttribute("myHtml", html);
        return "item_param";

    }
}
