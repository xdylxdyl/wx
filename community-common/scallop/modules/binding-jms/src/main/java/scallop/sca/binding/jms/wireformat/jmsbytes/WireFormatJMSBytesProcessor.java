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

import static javax.xml.stream.XMLStreamConstants.END_ELEMENT;
import static javax.xml.stream.XMLStreamConstants.START_ELEMENT;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.apache.tuscany.sca.assembly.xml.Constants;
import org.apache.tuscany.sca.contribution.ModelFactoryExtensionPoint;
import org.apache.tuscany.sca.contribution.processor.BaseStAXArtifactProcessor;
import org.apache.tuscany.sca.contribution.processor.StAXArtifactProcessor;
import org.apache.tuscany.sca.contribution.resolver.ModelResolver;
import org.apache.tuscany.sca.contribution.service.ContributionReadException;
import org.apache.tuscany.sca.contribution.service.ContributionResolveException;
import org.apache.tuscany.sca.contribution.service.ContributionWriteException;
import org.apache.tuscany.sca.monitor.Monitor;

import scallop.sca.binding.jms.impl.JMSBindingConstants;

/**
 *
 * @version $Rev: 712538 $ $Date: 2008-11-09 19:27:28 +0000 (Sun, 09 Nov 2008) $
 */
public class WireFormatJMSBytesProcessor extends BaseStAXArtifactProcessor implements StAXArtifactProcessor<WireFormatJMSBytes> {
    
    public QName getArtifactType() {
        return WireFormatJMSBytes.WIRE_FORMAT_JMS_BYTES_QNAME;
    }
    
    public WireFormatJMSBytesProcessor(ModelFactoryExtensionPoint modelFactories, Monitor monitor) {
    }

    
    public WireFormatJMSBytes read(XMLStreamReader reader) throws ContributionReadException, XMLStreamException {
        WireFormatJMSBytes wireFormat = new WireFormatJMSBytes();
         
        return wireFormat;
    }

    public void write(WireFormatJMSBytes wireFormat, XMLStreamWriter writer) 
        throws ContributionWriteException, XMLStreamException {
        String prefix = "scallop";
        writer.writeStartElement(prefix, 
                                 getArtifactType().getLocalPart(),
                                 getArtifactType().getNamespaceURI());
        writer.writeNamespace("scallop", JMSBindingConstants.SCA10_SCALLOP_NS); 
        
        writer.writeEndElement();
    }

    public Class<WireFormatJMSBytes> getModelType() {
        return WireFormatJMSBytes.class;
    }

    public void resolve(WireFormatJMSBytes arg0, ModelResolver arg1) throws ContributionResolveException {

    }
    
}
