package com.ecps.common;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.ecps.common.util.ProtoStuffSerializerUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * protoStuff 序列化测试类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 下午 05:46
 */
public class ProtoStuffSerializerTest {

    @Test
    public void testSerialize() {
        UserTest user = new UserTest();
        user.setAddress("浙江 杭州");
        user.setAge(3);
        user.setName("周星驰");
        user.setSex((byte) 1);


        Schema<UserTest> schema = (Schema<UserTest>) RuntimeSchema.getSchema(user.getClass());

        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

        byte[] bytes = ProtostuffIOUtil.toByteArray(user, schema, buffer);

        //FileUtils.writeByteArrayToFile(new File("F:/json.txt"), bytes);

        ProtostuffIOUtil.mergeFrom(bytes, user, schema);

        System.out.println("序列化后的结果：" + user);
    }

    @Test
    public void testSerializeList() {
        List<UserTest> list = new ArrayList<>();
        list.add(new UserTest(2, "成龙", (byte) 0, "浙江 杭州3"));
        list.add(new UserTest(22, "成龙2", (byte) 1, "浙江 杭州32"));

        Schema<UserTest> schema = RuntimeSchema.getSchema(UserTest.class);
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);

        byte[] bytes = null;
        ByteArrayOutputStream out = null;
        try {
            out = new ByteArrayOutputStream();
            ProtostuffIOUtil.writeListTo(out, list, schema, buffer);
            bytes = out.toByteArray();
            FileUtils.writeByteArrayToFile(new File("F:/json.txt"), bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            buffer.clear();
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //反序列化
        List<UserTest> userList = null;
        try {
            userList = ProtostuffIOUtil.parseListFrom(new ByteArrayInputStream(bytes), schema);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(userList);
    }

    @Test
    public void testSerializeList2(){
        List<UserTest> list = new ArrayList<>();
        list.add(new UserTest(2, "成龙", (byte) 0, "浙江 杭州3"));
        list.add(new UserTest(22, "成龙2", (byte) 1, "浙江 杭州32"));

        byte[] bytes = ProtoStuffSerializerUtil.serializeList(list);

        List<UserTest> userTests = ProtoStuffSerializerUtil.deserializeList(bytes, UserTest.class);
        System.out.println(userTests);
    }
}
