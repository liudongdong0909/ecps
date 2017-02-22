package com.ecps.common.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常信息类
 *
 * @author IT_donggua
 * @version V1.0
 * @create 2017-02-20 下午 02:13
 */
public class ExceptionUtil {

    public static String getStackTrace(Throwable e) {

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        try {
            e.printStackTrace(pw);
            return pw.toString();
        } finally {
            pw.close();
        }
    }
}
