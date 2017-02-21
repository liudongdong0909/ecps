package com.ecps.common.util;


/**
 * 封装FastDFS客户端对象
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:18
 */
public class FastDFSClient {

/*    private TrackerClient trackerClient = null;
    private TrackerServer trackerServer = null;
    private StorageServer storageServer = null;
    private StorageClient1 storageClient = null;

    public FastDFSClient(String conf) throws Exception {
        if (conf.contains("classpath:")) {
            conf = conf.replace("classpath:", this.getClass().getResource("/").getPath());
        }
        ClientGlobal.init(conf);
        trackerClient = new TrackerClient();
        trackerServer = trackerClient.getConnection();
        storageServer = null;
        storageClient = new StorageClient1(trackerServer, storageServer);
    }

    *//**
     * @Title: uploadFile
     * @Description: 文件上传方法
     * @param fileName
     *            文件全路径
     * @param extName
     *            文件扩展名 不包含.
     * @param metas
     *            文件扩展信息
     * @throws Exception
     * @return String
     *//*
    public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
        String result = storageClient.upload_file1(fileName, extName, metas);
        return result;
    }

    public String uploadFile(String fileName) throws Exception {
        return uploadFile(fileName, null, null);
    }

    public String uploadFile(String fileName, String extName) throws Exception {
        return uploadFile(fileName, extName, null);
    }

    *//**
     * @Title: uploadFile
     * @Description: 文件上传方法
     * @param fileContent
     *            文件内容 字节数组
     * @param extName
     *            文件扩展名 不包含.
     * @param metas
     *            文件扩展信息
     * @throws Exception
     * @return String
     *//*
    public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
        String result = storageClient.upload_file1(fileContent, extName, metas);
        return result;
    }

    public String uploadFile(byte[] fileContent) throws Exception {
        return uploadFile(fileContent, null, null);
    }

    public String uploadFile(byte[] fileContent, String extName) throws Exception {
        return uploadFile(fileContent, extName, null);
    }*/
}
