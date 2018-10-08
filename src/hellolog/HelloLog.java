package src.hellolog;

import java.util.logging.Logger;

/*
 * 类：Logger ；作用：日志记录
 * 方法：info() ；作用打印出日志信息
 *
 */

public final class HelloLog {

    private static Logger logger = Logger.getLogger("");

    public static void getLog(String msg) {
        logger.info(msg);
    }

}
