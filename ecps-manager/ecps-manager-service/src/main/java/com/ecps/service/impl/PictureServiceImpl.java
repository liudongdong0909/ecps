package com.ecps.service.impl;

import com.ecps.common.bean.PictureResult;
import com.ecps.common.enums.ECPSStatus;
import com.ecps.service.PictureService;
import com.ecps.service.base.impl.PropertiesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * 图片上传serviceImpl
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-23 下午 01:50
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PropertiesService propertiesService;

    @Override
    public PictureResult uploadPic(MultipartFile uploadFile) {

        PictureResult result =  new PictureResult();

        //上传图片不能为空
        if (uploadFile == null) {
            result.setError(ECPSStatus.PIC_UPLOAD_EMPTY.value());
            result.setMessage(ECPSStatus.PIC_UPLOAD_EMPTY.display());
            return result;
        }

        String[] picSuffixs = propertiesService.IMAGE_SUFFIX_NAME.split(",");
        //校验上传图片格式
        for (String type : picSuffixs) {
            if (!StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                result.setError(ECPSStatus.PIC_UPLOAD_SUFFIX_ERROR.value());
                result.setMessage(ECPSStatus.PIC_UPLOAD_SUFFIX_ERROR.display());
                return result;
            }
        }

        try {
            String originalFilename = uploadFile.getOriginalFilename();
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            String url = null;
            result.setError(ECPSStatus.PIC_UPLOAD_SUCCESS.value());
            result.setMessage(ECPSStatus.PIC_UPLOAD_SUCCESS.display());
            result.setUrl(url);

        } catch (Exception e) {
            e.printStackTrace();
            result.setError(ECPSStatus.PIC_UPLOAD_ERROR.value());
            result.setMessage(ECPSStatus.PIC_UPLOAD_ERROR.display());
            return result;
        }

        return result;
    }
}
