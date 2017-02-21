package com.ecps.common.bean;

/**
 * 封装KEditor接受的类型
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:16
 */
public class PictureResult {

    private int error;

    private String url;

    private String message;

    public PictureResult() {
        super();
    }

    public PictureResult(int error, String url, String message) {
        super();
        this.error = error;
        this.url = url;
        this.message = message;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PictureResult [error=" + error + ", url=" + url + ", message=" + message + "]";
    }

}
