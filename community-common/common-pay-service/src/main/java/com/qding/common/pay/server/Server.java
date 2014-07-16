package com.qding.common.pay.server;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.SCANode;
import org.apache.tuscany.sca.node.SCANodeFactory;

/**
 * 鏈嶅姟鍚姩绫�
 *
 * @author 
 */
public class Server {
    private static Log log = LogFactory.getLog(Server.class);
    private static SCANode node;

    /**
     * start account server.
     *
     * @throws java.io.IOException IOException
     */
    public void start() throws Exception {

        if (log.isInfoEnabled()) {
            log.info("===> common-pay-service Start Begin");
        }
    
        node = SCANodeFactory.newInstance().createSCANode("META-INF/common-pay-service/server.composite");
        node.start();
		
        if (log.isInfoEnabled()) {
            log.info("===>common-pay-service");
        }
    }

    /**
     * exit system
     */
    public void exit() {
        System.exit(0);
    }

    public void run() throws InterruptedException {
        while (true) {
            Thread.sleep(Long.MAX_VALUE);
        }
    }

    /**
     * 鏈嶅姟鍚姩绋嬪簭.
     * @param args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
        try {
            server.run();
            
        } catch (InterruptedException e) {
            log.error("common-pay-service server run error ", e);
        }
    }
}

