package com.ecps.service.impl;

import com.ecps.common.bean.PictureResult;
import com.ecps.common.enums.ECPSStatus;
import com.ecps.common.util.FastDFSClient;
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

    //fastdfs 服务器配置路径
    private static final String FASTDFS_CONFIGPATH = "classpath:/properties/fastdfsc_client.conf";

    @Override
    public PictureResult uploadPic(MultipartFile uploadFile) {

        if (uploadFile == null) {
            // 上传图片不能为空
            return new PictureResult(ECPSStatus.PIC_UPLOAD_EMPTY, null);
        }

        String originalFilename = uploadFile.getOriginalFilename();
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        boolean contains = StringUtils.contains(propertiesService.IMAGE_SUFFIX_NAME, suffixName);
        if (!contains) {
            // 图片类型不对
            return new PictureResult(ECPSStatus.PIC_UPLOAD_SUFFIX_ERROR, null);
        }


        try {
            FastDFSClient fastDFSClient = new FastDFSClient(FASTDFS_CONFIGPATH);
            String url = fastDFSClient.uploadFile(uploadFile.getBytes(), suffixName);
            url = propertiesService.IMAGE_SERVER_BASE_URL + url;
            // 图片上传成功
            System.out.println(new PictureResult(ECPSStatus.PIC_UPLOAD_SUCCESS, url));
            return new PictureResult(ECPSStatus.PIC_UPLOAD_SUCCESS, url);

        } catch (Exception e) {
            e.printStackTrace();
            // 图片上传失败
            return new PictureResult(ECPSStatus.PIC_UPLOAD_ERROR, null);
        }

    }
}
