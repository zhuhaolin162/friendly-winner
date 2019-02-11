package com.pytc.chat;

import com.pytc.chat.util.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * webSocket聊天室服务端
 * @author zhu
 */
public class HappyChatMain {
    private static final Logger logger = LoggerFactory.getLogger(HappyChatMain.class);

    public static void main(String[] args) {
        final HappyChatServer server = new HappyChatServer(Constants.DEFAULT_PORT);
        server.init();
        server.start();
        // 注册进程钩子，在JVM进程关闭前释放资源
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                server.shutdown();
                logger.warn(">>>>>>>>>> jvm shutdown");
                System.exit(0);
            }
        });
    }
}
