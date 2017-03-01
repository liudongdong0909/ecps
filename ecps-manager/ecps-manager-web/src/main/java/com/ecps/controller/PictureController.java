package com.ecps.controller;

import com.ecps.common.bean.PictureResult;
import com.ecps.common.util.ECPSJsonUtil;
import com.ecps.service.PictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传controller
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-23 下午 01:44
 */
@Controller
@RequestMapping("pic")
public class PictureController {

    private  static final Logger logger = LoggerFactory.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public String uploadPic(@RequestParam("uploadFile") MultipartFile uploadFile){

        PictureResult result = pictureService.uploadPic(uploadFile);
        return ECPSJsonUtil.objectToJson(result);
    }
}
