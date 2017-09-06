/**
 * ContentDeployResultSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.contentdeployresult.iptv;

public class ContentDeployResultSoapBindingSkeleton implements org.contentdeployresult.iptv.ContentDeployResult, org.apache.axis.wsdl.Skeleton {
    private org.contentdeployresult.iptv.ContentDeployResult impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CMSID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SOPID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CorrelateID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ResultCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ErrorDescription"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ResultFileURL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("contentDeployResult", _params, new javax.xml.namespace.QName("", "ContentDeployResultReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("iptv", "ContentDeployResultResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("iptv", "ContentDeployResult"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("contentDeployResult") == null) {
            _myOperations.put("contentDeployResult", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("contentDeployResult")).add(_oper);
    }

    public ContentDeployResultSoapBindingSkeleton() {
        this.impl = new org.contentdeployresult.iptv.ContentDeployResultSoapBindingImpl();
    }

    public ContentDeployResultSoapBindingSkeleton(org.contentdeployresult.iptv.ContentDeployResult impl) {
        this.impl = impl;
    }
    public org.contentdeployresult.iptv.ContentDeployResultResponse contentDeployResult(java.lang.String CMSID, java.lang.String SOPID, java.lang.String correlateID, int resultCode, java.lang.String errorDescription, java.lang.String resultFileURL) throws java.rmi.RemoteException
    {
        org.contentdeployresult.iptv.ContentDeployResultResponse ret = impl.contentDeployResult(CMSID, SOPID, correlateID, resultCode, errorDescription, resultFileURL);
        return ret;
    }

}
