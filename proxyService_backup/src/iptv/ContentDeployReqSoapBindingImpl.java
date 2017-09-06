package iptv;

import java.util.Date;

import model.ContentDeploy;
import dao.impl.DaoImpl;
import dao.IDao;
import service.ServicePool;


/**
 * 服务端实现类
 * @author nzq
 *
 */
public class ContentDeployReqSoapBindingImpl implements iptv.ContentDeployReq{
	IDao dao = new DaoImpl();
    public ContentDeployReqResponse contentDeployReq(java.lang.String CMSID, java.lang.String SOPID, 
    													  java.lang.String correlateID, java.lang.String cmdFileURL) throws java.rmi.RemoteException {
    	System.out.println("["+new Date()+"]:");
    	System.out.println("\tCMSID:["+CMSID+"];");
    	System.out.println("\tSOPID:["+SOPID+"];");
    	System.out.println("\tcorrelateID:["+correlateID+"];");
    	System.out.println("\tcmdFileURL:["+cmdFileURL+"];"); 
    	//同步返回消息，详情见视达科对接文档
    	if(!CMSID.equals("starcor")){
    		return new ContentDeployReqResponse("CMSID is not vaild!", -4000);
    	}
    	if(!SOPID.equals("pln_live")){
    		return new ContentDeployReqResponse("SOPID is not vaild!!", -4001);
    	}
    	//自定义的对象，用于存储四个值
    	ContentDeploy cd = new ContentDeploy(CMSID, SOPID, correlateID, cmdFileURL);
    	//线程池
    	ServicePool sp = ServicePool.getInstance();
    	//向线程池中注入对象
    	sp.addContentDeploy(cd);
    	//如果线程不存在则启动线程
    	if(!sp.isAlive()){
    		sp.start();
    	}
    	//返回成功信息
		return new ContentDeployReqResponse("send success!", 0);
    }
}
