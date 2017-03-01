package com.ecps.common.enums;

/**
 * 封装ECPS系统全局状态
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:07
 */
public enum ECPSStatus {

    // HTTP STATUS
    // 400 - Bad Reques
    BAD_REQUEST(400, "提交参数不匹配"),

    // 404 - not found
    NOT_FOUND(404, "请求结果未找到"),

    // 405 - Method Not Allowed
    METHOD_NOT_ALLOWED(405, "请求方法类型不匹配"),

    // 415 - Unsupported Media Type
    UNSUPPORTED_MEDIA_TYPE(415, "不支持当前媒体类型"),

    // 2XX成功
    SUCCESS(200, "操作成功"),
    // 5xx失败
    ERROR(500, "操作失败"),

    PIC_UPLOAD_SUCCESS(0, "上传图片成功"),
    PIC_UPLOAD_EMPTY(1, "上传图片为空"),
    PIC_UPLOAD_SUFFIX_ERROR(2, "上传图片格式不对"),
    PIC_UPLOAD_ERROR(3, "上传图片失败")


    ;

    private int value;

    private String display;

    ECPSStatus() {
    }

    ECPSStatus(int value, String display) {
        this.value = value;
        this.display = display;
    }

    public int value() {
        return value;
    }

    public String display() {
        return display;
    }

}
