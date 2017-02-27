package com.ecps.common;

import org.apache.commons.io.FileUtils;
import org.csource.fastdfs.*;
import org.junit.Test;

import java.io.File;

/**
 * FastDFS测试类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-24 下午 01:48
 */
public class FastDFSTest {

    @Test
    public void upload() throws Exception {
        // 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("F:\\IDEA_SPACE_2016\\ecps\\ecps-manager\\ecps-manager-web\\src\\main\\resources\\properties\\fastdfsc_client.conf");
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        // 7、直接调用StorageClient对象方法上传文件即可。
        String[] strings = storageClient.upload_file("C:\\Users\\zjcap_03\\Pictures\\f45b108904f4832fd74739c0f4eec8f8.jpg", "jpg", null);
        for (String string : strings) {
            System.out.println(string);
        }

    }

    @Test
    public void upload1() throws Exception{
// 1、把FastDFS提供的jar包添加到工程中
        // 2、初始化全局配置。加载一个配置文件。
        ClientGlobal.init("F:\\IDEA_SPACE_2016\\ecps\\ecps-manager\\ecps-manager-web\\src\\main\\resources\\properties\\fastdfsc_client.conf");
        // 3、创建一个TrackerClient对象。
        TrackerClient trackerClient = new TrackerClient();
        // 4、创建一个TrackerServer对象。
        TrackerServer trackerServer = trackerClient.getConnection();
        // 5、声明一个StorageServer对象，null。
        StorageServer storageServer = null;
        // 6、获得StorageClient对象。
        StorageClient1 storageClient = new StorageClient1(trackerServer, storageServer);
        File file = new File("C:\\Users\\zjcap_03\\Desktop\\其他模块与项目信息相关接口修改.docx");
        String String = storageClient.upload_file1(FileUtils.readFileToByteArray(file), "docx", null);
        System.out.println(String);
    }
}
