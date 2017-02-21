package com.ecps.common.bean;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

/**
 * 封装ecps系统全局响应结构
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:14
 */
public class ECPSResult {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应数据
    private Object data;

    public ECPSResult() {

    }

    public ECPSResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 返回状态为200的结果
     *
     * @param data
     */
    public ECPSResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ECPSResult build(Integer status, String msg, Object data) {
        return new ECPSResult(status, msg, data);
    }

    /**
     * @param data
     * @return ECPSResult
     * @Title: ok
     * @Description: 返回状态是200的结果  status=200 & msg ="OK"
     */
    public static ECPSResult ok(Object data) {
        return new ECPSResult(data);
    }

    public static ECPSResult ok() {
        return new ECPSResult(null);
    }

    /**
     * @param status
     * @param msg
     * @return ECPSResult
     * @Title: build
     * @Description: 只返回状态和消息的结果
     */
    public static ECPSResult build(Integer status, String msg) {
        return new ECPSResult(status, msg, null);
    }

    /**
     * @param jsonData json 数据
     * @param clazz    ECPSResult 中的object数据类型
     * @return ECPSResult
     * @Title: formatToPojo
     * @Description: 将json结果集转化为ECPSResult 对象
     */
    public static ECPSResult formatToPojo(String jsonData, Class<?> clazz) {

        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ECPSResult.class);
            }

            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object object = null;
            if (clazz != null) {
                if (data.isObject()) {
                    object = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    object = MAPPER.readValue(data.asText(), clazz);
                }
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
        } catch (JsonParseException e) {
            e.printStackTrace();
            return null;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param json
     * @return ECPSResult
     * @Title: format
     * @Description: 没有object对象的转化
     */
    public static ECPSResult format(String json) {
        try {
            return MAPPER.readValue(json, ECPSResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return ECPSResult
     * @Title: formatToList
     * @Description: Object是集合转化
     */
    public static ECPSResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
