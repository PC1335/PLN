/**
 * ContentDeployReqSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package iptv;

import java.io.File;
import java.io.IOException;

import utils.BaseDao;

public class ContentDeployReqSoapBindingSkeleton implements iptv.ContentDeployReq, org.apache.axis.wsdl.Skeleton {
    private iptv.ContentDeployReq impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }
    /**
    * 返回OperationDescs的集合
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
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CmdFileURL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("contentDeployReq", _params, new javax.xml.namespace.QName("", "ContentDeployReqReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("iptv", "ContentDeployReqResponse"));
        _oper.setElementQName(new javax.xml.namespace.QName("iptv", "ContentDeployReq"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("contentDeployReq") == null) {
            _myOperations.put("contentDeployReq", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("contentDeployReq")).add(_oper);
    }

    public ContentDeployReqSoapBindingSkeleton() {
        this.impl = new iptv.ContentDeployReqSoapBindingImpl();
    }

    public ContentDeployReqSoapBindingSkeleton(iptv.ContentDeployReq impl) {
        this.impl = impl;
    }
    
    public iptv.ContentDeployReqResponse contentDeployReq(java.lang.String CMSID, java.lang.String SOPID, java.lang.String correlateID, java.lang.String cmdFileURL) throws java.rmi.RemoteException
    {
        iptv.ContentDeployReqResponse ret = impl.contentDeployReq(CMSID, SOPID, correlateID, cmdFileURL);
        return ret;
    }

}
