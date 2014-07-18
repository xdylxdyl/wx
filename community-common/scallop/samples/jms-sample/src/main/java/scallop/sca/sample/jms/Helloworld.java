package scallop.sca.sample.jms;

import java.util.List;

import org.osoa.sca.annotations.OneWay;
import org.osoa.sca.annotations.Remotable;

@Remotable
public interface Helloworld {

	@OneWay
    void sayHello(String name) ;
	@OneWay
	void sayHelloMultiParams(String name, List<String> list) ;
	@OneWay
	void sayHelloArrays(String[] names) ;

}
