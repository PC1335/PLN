/**
 * ContentDeployResult.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.contentdeployresult.iptv;

public interface ContentDeployResult extends java.rmi.Remote {
    public org.contentdeployresult.iptv.ContentDeployResultResponse contentDeployResult(java.lang.String CMSID, java.lang.String SOPID, java.lang.String correlateID, int resultCode, java.lang.String errorDescription, java.lang.String resultFileURL) throws java.rmi.RemoteException;
}
