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
package scallop.sca.binding.jms.impl;

import java.util.Arrays;
import java.util.List;

import javax.xml.namespace.QName;

/**
 * Constants for the JMS binding.
 *
 * @version $Rev: 711271 $ $Date: 2008-11-04 15:24:34 +0000 (Tue, 04 Nov 2008) $
 */
public interface JMSBindingConstants {
	String SCA10_SCALLOP_NS = "http://scallop/xmlns/sca/1.0";
	// Constants used when describing the JMS binding
    // model and for setting up defaults
    String BINDING_JMS = "binding.jms";
    
    QName BINDING_JMS_QNAME = new QName(SCA10_SCALLOP_NS, BINDING_JMS);
    String CORRELATE_MSG_ID = "requestmsgidtocorrelid";
    String CORRELATE_CORRELATION_ID = "requestcorrelidtocorrelid";
    String CORRELATE_NONE = "none";
    List<String> VALID_CORRELATION_SCHEMES =
        Arrays.asList(new String[] {CORRELATE_MSG_ID, CORRELATE_CORRELATION_ID, CORRELATE_NONE});
    String DESTINATION_TYPE_QUEUE = "queue"; // 0
    String DESTINATION_TYPE_TOPIC = "topic"; // 1
    List<String> VALID_DESTINATION_TYPES =
        Arrays.asList(new String[] {DESTINATION_TYPE_QUEUE, DESTINATION_TYPE_TOPIC});
    String CREATE_ALWAYS = "always";
    String CREATE_NEVER = "never";
    String CREATE_IF_NOT_EXIST = "ifnotexist";
    String DEFAULT_DESTINATION_NAME = "NODESTINATION";
    String DEFAULT_RESPONSE_DESTINATION_NAME = "NORESPONSEDESTINATION";
    String DEFAULT_CONNECTION_FACTORY_NAME = "ConnectionFactory";
    String DEFAULT_CONTEXT_FACTORY_NAME = "org.apache.activemq.jndi.ActiveMQInitialContextFactory";
    String DEFAULT_JNDI_URL = "tcp://localhost:61616";
    int DEFAULT_TIME_TO_LIVE = 20000; // in milliseconds
    int DEFAULT_PRIORITY = 1;
    int NON_PERSISTENT = 1; // Maps to javax.jms.DeliveryMode
    String DEFAULT_RF_CLASSNAME = "scallop.sca.host.jms.activemq.JMSResourceFactoryImpl";
    String XML_MP_CLASSNAME = "scallop.sca.binding.jms.provider.XMLTextMessageProcessor";
    String TEXT_MP_CLASSNAME = "scallop.sca.binding.jms.provider.TextMessageProcessor";
    String OBJECT_MP_CLASSNAME = "scallop.sca.binding.jms.provider.ObjectMessageProcessor";
    String BYTES_MP_CLASSNAME = "scallop.sca.binding.jms.provider.BytesMessageProcessor";
    String DEFAULT_MP_CLASSNAME = XML_MP_CLASSNAME;
    String DEFAULT_OPERATION_PROP_NAME = "scaOperationName";

    String FAULT_PROPERTY = "org_apache_tuscany_sca_fault";
    
    String CALLBACK_ID_PROPERTY = "CallbackID";
    String CALLBACK_Q_PROPERTY = "scaCallbackQueue ";
    String CONVERSATION_ID_PROPERTY = "scaConversationId";
    
    int MSG_CTXT_POSITION = 0;
}
