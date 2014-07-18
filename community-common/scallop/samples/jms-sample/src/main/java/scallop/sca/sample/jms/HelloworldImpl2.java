package scallop.sca.sample.jms;

import java.util.List;

public class HelloworldImpl2 implements Helloworld {

    public void sayHello(String name) {
    	System.out.println("HelloworldImpl2:Hello " + name);
    }

    @Override
    public void sayHelloMultiParams(String name, List<String> list) {
    	System.out.println("HelloworldImpl2:hello " + name + " list :" + list.toString());
    }

    @Override
    public void sayHelloArrays(String[] names) {
    	System.out.println("HelloworldImpl2:hello " + names.toString());
    }

}
