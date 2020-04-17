package com.example.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *
 * </pre>
 * @author 杨帮东
 * @since 1.0
 * @date 2020/04/17 17:25
 **/
public class TrackUtils {

    private static final Logger logger = LoggerFactory.getLogger(TrackUtils.class);


    /**
     * 打印当前线程堆栈信息
     * @param prefix
     */
    public static void printTrack(String prefix) {
        StackTraceElement[] st = Thread.currentThread().getStackTrace();

        if (null == st) {
            logger.info("invalid stack");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (StackTraceElement e : st) {
            if (sb.length() > 0) {
                sb.append(" <- ");
                sb.append(System.getProperty("line.separator"));
            }

            sb.append(java.text.MessageFormat.format("{0}.{1}() {2}", e.getClassName(), e.getMethodName(),
                    e.getLineNumber()));
        }

        logger.info("\n{} " +
                "\n****************************************************************\n {} " +
                "\n****************************************************************",
                prefix, sb);
    }
}
