package scallop.sca.sample.jms;

import java.util.List;

public class HelloworldClientImpl implements Helloworld{

    private Helloworld helloworld;
    
    public void setHelloworld(Helloworld helloworld) {
        this.helloworld = helloworld;
    }

    @Override
    public void sayHello(String name) {
        helloworld.sayHello(name);
    }

    @Override
    public void sayHelloMultiParams(String name, List<String> list)  {
    	helloworld.sayHelloMultiParams(name, list);
    }

    @Override
    public void sayHelloArrays(String[] names) {
        helloworld.sayHelloArrays(names);
    }

}
