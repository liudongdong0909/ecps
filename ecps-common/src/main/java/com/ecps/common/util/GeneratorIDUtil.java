package com.ecps.common.util;

import java.util.Random;

/**
 * ECPS系统中各种id的生成策略
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-21 上午 09:59
 */
public class GeneratorIDUtil {

    /**
     * @Title: genImageName
     * @Description: 图片名称
     * @return String
     */
    public static String genImageName() {
        long timeMillis = System.currentTimeMillis();
        Random random = new Random();
        // 加三位随机数
        int nextInt = random.nextInt(999);
        // 不足三位在前面补0
        String str = timeMillis + String.format("%03d", nextInt);
        return str;
    }

    /**
     * @Title: genItemId
     * @Description: 商品id
     * @return long
     */
    public static long genItemId() {
        long timeMillis = System.currentTimeMillis();
        Random random = new Random();
        // 加2位随机数
        int nextInt = random.nextInt(99);
        // 不足两位在前面补0
        String str = timeMillis + String.format("%02d", nextInt);
        long id = new Long(str);
        return id;
    }
}
