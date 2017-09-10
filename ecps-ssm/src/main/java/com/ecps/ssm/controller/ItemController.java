package com.ecps.ssm.controller;

import com.ecps.ssm.common.EasyUIResult;
import com.ecps.ssm.pojo.TbItem;
import com.ecps.ssm.service.ItemService;
import com.github.pagehelper.PageInfo;
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
 * 商品controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-15 上午 11:09
 */
@Controller
@RequestMapping("item")
public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryPageList(@RequestParam(value = "page",defaultValue= "1") Integer page,
                                      @RequestParam(value = "rows", defaultValue = "10")Integer rows){
        TbItem item = new TbItem();
        PageInfo<TbItem> pageInfo = itemService.queryPageListByWhere(item, page, rows);

        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryItemList(@RequestParam(value = "page",defaultValue= "1") Integer page,
                                                      @RequestParam(value = "rows", defaultValue = "10")Integer rows){
        try {
            if (logger.isInfoEnabled()){
                logger.info("查询商品分页:page= {}, rows= {}", page, rows);
            }
            TbItem item = new TbItem();
            PageInfo<TbItem> pageInfo = itemService.queryPageListByWhere(item, page, rows);
            if (pageInfo == null){
                if (logger.isInfoEnabled()){
                    logger.info("查询商品分页不存在:page= {}, rows= {}", page, rows);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }
            }
            EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("查询商品分页失败: page={}, rows= {}", page, rows, e);
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
        }
    }

}
