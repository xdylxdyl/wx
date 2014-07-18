package scallop.sca.sample.rmi;

import java.rmi.server.ServerCloneException;
import java.util.List;

public class HelloworldClientImpl implements Helloworld{

    private Helloworld helloworld;
    
    public void setHelloworld(Helloworld helloworld) {
        this.helloworld = helloworld;
    }

    @Override
    public String sayHello(String name) throws ServerCloneException {
        return helloworld.sayHello(name);
    }

    @Override
    public String sayHelloMultiParams(String name, List<String> list) throws ServerCloneException {
        return helloworld.sayHelloMultiParams(name, list);
    }

    @Override
    public String sayHelloArrays(String[] names) throws ServerCloneException {
        return helloworld.sayHelloArrays(names);
    }

}
