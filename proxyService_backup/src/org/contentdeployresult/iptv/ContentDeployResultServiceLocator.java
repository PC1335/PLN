/**
 * ContentDeployResultServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.contentdeployresult.iptv;

public class ContentDeployResultServiceLocator extends org.apache.axis.client.Service implements org.contentdeployresult.iptv.ContentDeployResultService {

    public ContentDeployResultServiceLocator() {
    }


    public ContentDeployResultServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ContentDeployResultServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ContentDeployResult
    private java.lang.String ContentDeployResult_address = "http://172.26.2.17/nn_bk/mgtv/pln_live/notify.php";

    public java.lang.String getContentDeployResultAddress() {
        return ContentDeployResult_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ContentDeployResultWSDDServiceName = "ContentDeployResult";

    public java.lang.String getContentDeployResultWSDDServiceName() {
        return ContentDeployResultWSDDServiceName;
    }

    public void setContentDeployResultWSDDServiceName(java.lang.String name) {
        ContentDeployResultWSDDServiceName = name;
    }

    public org.contentdeployresult.iptv.ContentDeployResult getContentDeployResult() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ContentDeployResult_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getContentDeployResult(endpoint);
    }

    public org.contentdeployresult.iptv.ContentDeployResult getContentDeployResult(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.contentdeployresult.iptv.ContentDeployResultSoapBindingStub _stub = new org.contentdeployresult.iptv.ContentDeployResultSoapBindingStub(portAddress, this);
            _stub.setPortName(getContentDeployResultWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setContentDeployResultEndpointAddress(java.lang.String address) {
        ContentDeployResult_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.contentdeployresult.iptv.ContentDeployResult.class.isAssignableFrom(serviceEndpointInterface)) {
                org.contentdeployresult.iptv.ContentDeployResultSoapBindingStub _stub = new org.contentdeployresult.iptv.ContentDeployResultSoapBindingStub(new java.net.URL(ContentDeployResult_address), this);
                _stub.setPortName(getContentDeployResultWSDDServiceName());
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
        if ("ContentDeployResult".equals(inputPortName)) {
            return getContentDeployResult();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("iptv", "ContentDeployResultService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("iptv", "ContentDeployResult"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ContentDeployResult".equals(portName)) {
            setContentDeployResultEndpointAddress(address);
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
