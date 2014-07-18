/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package scallop.sca.sample.rmi;

import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * This client program shows how to create an SCA runtime, start it,
 * and locate and invoke a SCA component
 * @version $Rev: 567952 $ $Date: 2007-08-21 10:20:22 +0530 (Tue, 21 Aug 2007) $
 */
public class Client {
    
    public static void main(String[] args) throws Exception {

        SCADomain scaDomain  = SCADomain.newInstance("client.composite");

        // Call the echo service component which will, in turn, call a reference
        // with an echo binding. The echo binding will echo the given string.
        Helloworld service = scaDomain.getService(Helloworld.class, "HelloworldClientComponent");
        Helloworld service2 = scaDomain.getService(Helloworld.class, "HelloworldClientComponent2");
        while (true) {
            try {
                Thread.sleep(5000);
                //String echoString = service.sayHello("Freeway");
                String echoString = service.sayHello("xdyl");
                System.out.println("Echo1 reference = " + echoString );
                //echoString = service2.sayHello("world");
                echoString = service2.sayHelloArrays(new String[]{"1111","1111"});
                System.out.println("Echo2 reference = " + echoString );
            } catch(Exception exp) {
                exp.printStackTrace();
            }
        }
        // Call the echo server. This will dispatch the call to a service with an 
        // echo binding. The echo binding will pass the call to the echo component.
        // scaDomain.close();
    }

}
