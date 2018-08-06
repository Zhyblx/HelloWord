package src.hellolog;

import java.util.logging.Logger;

public final class HelloLog {

    private static Logger logger = Logger.getLogger("");

    public static void getLog(String msg) {
        logger.info(msg);
    }

}
