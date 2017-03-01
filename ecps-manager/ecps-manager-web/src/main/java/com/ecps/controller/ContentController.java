package com.ecps.controller;

import com.ecps.common.bean.ECPSResult;
import com.ecps.common.bean.EasyUIResult;
import com.ecps.model.TbContent;
import com.ecps.service.ContentService;
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
 * 内容管理Controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-01 下午 04:05
 */
@Controller
@RequestMapping("content")
public class ContentController {

    private static Logger logger = LoggerFactory.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "save", method = RequestMethod.POST)
    @ResponseBody
    public ECPSResult insertContent(TbContent content) {

        try {
            contentService.save(content);

            if (logger.isInfoEnabled()) {
                logger.info("新增内容成功: tbContent= {}", content);
            }
            return ECPSResult.success();

        } catch (Exception e) {
            logger.error("新增内容失败: tbContent= {}", content, e);
        }
        return ECPSResult.error();
    }

    @RequestMapping(value = "/query/list", method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryContentList(@RequestParam(value = "categoryId", defaultValue = "0") Long categoryId,
                                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                         @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        try {
            TbContent content = new TbContent();
            content.setCategoryId(categoryId);
            PageInfo<TbContent> pageInfo = contentService.queryPageListByWhere(content, page, rows);
            if (pageInfo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            EasyUIResult result = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
            if (logger.isInfoEnabled()) {
                logger.info("内容分类分页查询: categoryId= {}, page= {}, rows= {}", categoryId, page, rows);
            }
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            logger.error("内容分类分页查询失败: categoryId= {}, page= {}, rows= {}", categoryId, page, rows, e);
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
    }
}
