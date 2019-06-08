/**
 * EArchiveLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package tr.com.diyalogo.www.sendEArchiveXml;

public class EArchiveLocator extends org.apache.axis.client.Service implements tr.com.diyalogo.www.sendEArchiveXml.EArchive {

    public EArchiveLocator() {
    }


    public EArchiveLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EArchiveLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for eArchiveSoap
    private java.lang.String eArchiveSoap_address = "https://pbtest.diyalogo.com.tr/earchive/eArchive.asmx";

    public java.lang.String geteArchiveSoapAddress() {
        return eArchiveSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String eArchiveSoapWSDDServiceName = "eArchiveSoap";

    public java.lang.String geteArchiveSoapWSDDServiceName() {
        return eArchiveSoapWSDDServiceName;
    }

    public void seteArchiveSoapWSDDServiceName(java.lang.String name) {
        eArchiveSoapWSDDServiceName = name;
    }

    public tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap geteArchiveSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(eArchiveSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return geteArchiveSoap(endpoint);
    }

    public tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap geteArchiveSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoapStub _stub = new tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoapStub(portAddress, this);
            _stub.setPortName(geteArchiveSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void seteArchiveSoapEndpointAddress(java.lang.String address) {
        eArchiveSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoapStub _stub = new tr.com.diyalogo.www.sendEArchiveXml.EArchiveSoapStub(new java.net.URL(eArchiveSoap_address), this);
                _stub.setPortName(geteArchiveSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("eArchiveSoap".equals(inputPortName)) {
            return geteArchiveSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.diyalogo.com.tr/sendEArchiveXml", "eArchive");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.diyalogo.com.tr/sendEArchiveXml", "eArchiveSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("eArchiveSoap".equals(portName)) {
            seteArchiveSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
