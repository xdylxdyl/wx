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
package scallop.sca.binding.jms.wireformat.jmsbytes;

import javax.xml.namespace.QName;

import org.apache.tuscany.sca.assembly.WireFormat;

import scallop.sca.binding.jms.impl.JMSBindingConstants;

/**
 * Implementation for policies that could be injected as parameter
 * into the axis2config.
 *
 * @version $Rev: 712538 $ $Date: 2008-11-09 19:27:28 +0000 (Sun, 09 Nov 2008) $
 */
public class WireFormatJMSBytes implements WireFormat {
    public static final QName WIRE_FORMAT_JMS_BYTES_QNAME = new QName(JMSBindingConstants.SCA10_SCALLOP_NS, "wireFormat.jmsBytes");
    
    public QName getSchemaName() {
        return WIRE_FORMAT_JMS_BYTES_QNAME;
    }

    public boolean isUnresolved() {
        return false;
    }

    public void setUnresolved(boolean unresolved) {
    }
}
