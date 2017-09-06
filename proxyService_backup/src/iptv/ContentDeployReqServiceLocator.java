/**
 * ContentDeployReqServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package iptv;

public class ContentDeployReqServiceLocator extends org.apache.axis.client.Service implements iptv.ContentDeployReqService {

    public ContentDeployReqServiceLocator() {
    }


    public ContentDeployReqServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContentDeployReqServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContentDeployReq
    private java.lang.String ContentDeployReq_address = "http://172.26.2.17/nn_bk/mgtv/pln_live/notify.php";

    public java.lang.String getContentDeployReqAddress() {
        return ContentDeployReq_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContentDeployReqWSDDServiceName = "ContentDeployReq";

    public java.lang.String getContentDeployReqWSDDServiceName() {
        return ContentDeployReqWSDDServiceName;
    }

    public void setContentDeployReqWSDDServiceName(java.lang.String name) {
        ContentDeployReqWSDDServiceName = name;
    }

    public iptv.ContentDeployReq getContentDeployReq() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContentDeployReq_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContentDeployReq(endpoint);
    }

    public iptv.ContentDeployReq getContentDeployReq(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            iptv.ContentDeployReqSoapBindingStub _stub = new iptv.ContentDeployReqSoapBindingStub(portAddress, this);
            _stub.setPortName(getContentDeployReqWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContentDeployReqEndpointAddress(java.lang.String address) {
        ContentDeployReq_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (iptv.ContentDeployReq.class.isAssignableFrom(serviceEndpointInterface)) {
                iptv.ContentDeployReqSoapBindingStub _stub = new iptv.ContentDeployReqSoapBindingStub(new java.net.URL(ContentDeployReq_address), this);
                _stub.setPortName(getContentDeployReqWSDDServiceName());
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
        if ("ContentDeployReq".equals(inputPortName)) {
            return getContentDeployReq();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("iptv", "ContentDeployReqService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("iptv", "ContentDeployReq"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContentDeployReq".equals(portName)) {
            setContentDeployReqEndpointAddress(address);
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
