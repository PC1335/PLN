package org.contentdeployresult.iptv;

import java.rmi.RemoteException;
import java.util.Date;

import javax.xml.rpc.ServiceException;

public class ContentDeployResultHandler {
	public ContentDeployResultHandler(){
	}
	public ContentDeployResultResponse contentDeployResultHandler(String CorrelateID,String resultFileURL){
		try {
			ContentDeployResultService service = new ContentDeployResultServiceLocator();
			ContentDeployResult result = service.getContentDeployResult();
			return result.contentDeployResult("pln_live", "starcor", CorrelateID, 0, null, resultFileURL);
		} catch (ServiceException e) {
		} catch (RemoteException e) {
		}return null;
	}
}
