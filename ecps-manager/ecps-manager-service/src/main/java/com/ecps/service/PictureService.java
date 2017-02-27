package com.ecps.service;

import com.ecps.common.bean.PictureResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传service厕
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-23 下午 01:48
 */
public interface PictureService {

    /**
     * 图片上传
     *
     * @param uploadFile
     * @return
     */
    PictureResult uploadPic(MultipartFile uploadFile);
}
