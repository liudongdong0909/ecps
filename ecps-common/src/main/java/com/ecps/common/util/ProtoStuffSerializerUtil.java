package com.ecps.common.util;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.objenesis.ObjenesisStd;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ProtoStuff 序列化 工具类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 05:43
 */
public class ProtoStuffSerializerUtil {

    private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();

    private static ObjenesisStd objenesisStd = new ObjenesisStd(true);

    private static <T> Schema<T> getSchema(Class<T> clazz) {

        Schema<T> schema = (Schema<T>) cachedSchema.get(clazz);
        if (schema == null) {
            schema = RuntimeSchema.getSchema(clazz);
            if (schema != null) {
                cachedSchema.put(clazz, schema);
            }
        }
        return schema;
    }

    /**
     * 序列化
     *
     * @param obj 传入对象
     * @param <T> 传入对象类型
     * @return
     */
    public static <T> byte[] serialize(T obj) {

        if (obj == null) {
            throw new RuntimeException("序列化对象为空!");
        }

        //根据class 创建 schema 对象
        Schema<T> schema = (Schema<T>) getSchema(obj.getClass());
        //创建默认大小的缓冲区域
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

        byte[] bytes = null;
        // 对象序列化 -> byte[]
        try {
            bytes = ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw new RuntimeException("序列化(" + obj.getClass() + ")对象(" + obj + ")发生异常!");
        } finally {
            buffer.clear();
        }

        return bytes;
    }

    /**
     * 反序列化
     *
     * @param data  对象的字节数组
     * @param clazz 对象的字节码
     * @param <T>   对象类型
     * @return
     */
    public static <T> T deserialize(byte[] data, Class<T> clazz) {

        if (ArrayUtils.isEmpty(data)) {
            throw new RuntimeException("发序列化对象发生异常，byte[] 数据为空!");
        }

        T message = null;

        try {
            message = (T) objenesisStd.newInstance(clazz);
            Schema<T> schema = getSchema(clazz);
            ProtostuffIOUtil.mergeFrom(data, message, schema);

        } catch (Exception e) {
            throw new RuntimeException("反序列化过程中依据类型创建对象失败!", e);
        }

        return message;
    }


    /**
     * 序列化 对象列表
     *
     * @param objList 对象列表
     * @param <T>     对象列表元素类型
     * @return
     */
    public static <T> byte[] serializeList(List<T> objList) {
        if (CollectionUtils.isEmpty(objList)) {
            throw new RuntimeException("序列化对象列表为空!");
        }

        Schema<T> schema = (Schema<T>) getSchema(objList.get(0).getClass());
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

        byte[] bytes = null;
        ByteArrayOutputStream bos = null;

        try {
            bos = new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(bos, objList, schema, buffer);
            bytes = bos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("序列化对象列表(" + objList + ")发生异常!", e);
        } finally {
            buffer.clear();
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bytes;
    }

    /**
     * 反序列化对象列表
     *
     * @param data  对象列表字节数组
     * @param clazz 对象列表元素字节码
     * @param <T>   对象列表元素类型
     * @return
     */
    public static <T> List<T> deserializeList(byte[] data, Class<T> clazz) {
        if (ArrayUtils.isEmpty(data)) {
            throw new RuntimeException("反序列化对象byte序列为空!");
        }

        Schema<T> schema = getSchema(clazz);
        List<T> result = null;
        try {
            result = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(data), schema);
        } catch (IOException e) {
            throw new RuntimeException("反序列化对象列表发生异常!", e);
        }
        return result;
    }

}
