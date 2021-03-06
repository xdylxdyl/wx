package scallop.sca.sample.rmi;

import java.rmi.server.ServerCloneException;
import java.util.List;

public class HelloworldImpl2 implements Helloworld {

    public String sayHello(String name) throws ServerCloneException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloworldImpl2:Hello " + name;
    }

    @Override
    public String sayHelloMultiParams(String name, List<String> list) throws ServerCloneException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloworldImpl2:hello " + name + " list :" + list.toString();
    }

    @Override
    public String sayHelloArrays(String[] names) throws ServerCloneException {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "HelloworldImpl2:hello " + names.toString();
    }

}
