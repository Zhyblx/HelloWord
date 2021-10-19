package src.hellolog;

import java.util.logging.Logger;

import src.hellointerface.HelloInterface;
/*
 * 类：Logger ；作用：日志记录
 * 方法：info() ；作用打印出日志信息
 *
 */

public final class HelloLog {

    private String className = "";

    /*
     * 私有化构造
     */
    private HelloLog(String className) {
        this.className = className;

    }

    /*
     * 单例模式
     */
    public static HelloLog getHelloLog(String className) {
        return new HelloLog(className);

    }

    /**
     * logger(日志类)
     *
     * @param args(可变参数)
     * @throws Exception
     * @author zhyblx
     */
    public void setLogger(String... args) throws Exception {
        Logger logger = Logger.getLogger(this.className);
        for (String str : args) {
            //logger.info(str);
            logger.severe(str);

        }
    }


    //    private static Logger logger = Logger.getLogger("");
//
//    public static void setLogger(Object msg) {
//        logger.info(String.valueOf(msg));
//
//    }
//
    public static void main(String[] args) throws Exception {
        HelloLog helloLog = HelloLog.getHelloLog("hellolog.HelloLog");
        helloLog.setLogger("cold,no problem !");
        helloLog.setLogger(HelloInterface.STRINGS);

    }
}
