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

    private String width;

    private String height;

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

    public PictureResult(int error, String url, String width, String height, String message) {
        this.error = error;
        this.url = url;
        this.width = width;
        this.height = height;
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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PictureResult{");
        sb.append("error=").append(error);
        sb.append(", url='").append(url).append('\'');
        sb.append(", width='").append(width).append('\'');
        sb.append(", height='").append(height).append('\'');
        sb.append(", message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
