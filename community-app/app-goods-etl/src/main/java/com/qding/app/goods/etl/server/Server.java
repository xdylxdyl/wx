package com.qding.app.goods.etl.server;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tuscany.sca.node.SCANode;
import org.apache.tuscany.sca.node.SCANodeFactory;

/**
 * 服务启动类
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
            log.info("===> app-goods-etl Start Begin");
        }
    
        node = SCANodeFactory.newInstance().createSCANode("META-INF/app-goods-etl/server.composite");
        node.start();
		
        if (log.isInfoEnabled()) {
            log.info("===>app-goods-etl");
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
     * 服务启动程序.
     * @param args
     * @throws Exception Exception
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server();
        server.start();
        try {
            server.run();
            
        } catch (InterruptedException e) {
            log.error("app-goods-etl server run error ", e);
        }
    }
}

