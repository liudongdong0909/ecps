package com.ecps.common.bean;

/**
 * Hibernate Validator 参数校验结果封装类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-03-14 上午 12:00
 */
public class ValidatorResult {

   /* *//**
     * 类名
     *//*
    private String className;*/


    /**
     * 字段名
     */
    private String filed;

    /**
     * 消息提示
     */
    private String message;

    public ValidatorResult() {
    }

    public ValidatorResult(String filed, String message) {
        this.filed = filed;
        this.message = message;
    }

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ValidatorResult{" +
                "filed='" + filed + '\'' +
                ", message='" + message + '\'' +
                '}';
    }


}

