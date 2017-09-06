package service;

import java.util.ArrayList;
import java.util.List;

import model.ContentDeploy;

import org.contentdeployresult.iptv.ContentDeployResult;

import utils.BaseDao;
/*
 * 线程池
 * 用于处理解析任务
 */
public class ServicePool extends Thread {
	//懒汉单例
	private static ServicePool sp = null;
	//定义一个消息处理对象
	private static MessageHandler mh = new MessageHandler();
	//不能被外界直接实例化
	//当新数据来的时候清除非当前
	private ServicePool(){
		String sql = "DELETE FROM schedulerecord WHERE s_startdate != date_format(now(),'20%y%m%d') and s_startdate != date_format(DATE_SUB(curdate(),INTERVAL 1 DAY),'20%y%m%d')";
		BaseDao.baseUpdate(sql);
	}
	//当sp为空才能实例化
	public static ServicePool getInstance(){
		if(sp==null)
			sp = new ServicePool();
		return sp;
	}
	//用一个list存储对象，构造一个池子
	private static List<ContentDeploy> cdPool = new ArrayList<ContentDeploy>();
	//外部调用可以往list中添加对象，向池子中注水
	public void addContentDeploy(ContentDeploy cd){
		cdPool.add(cd);
	}
	@Override
	public void run() {
		int count=0;
		//一个不断执行的死循环
		while(true){
			//当池子里有水时，是放水的
			if(cdPool.size()!=0){
				//放出池子中最底下的水
				ContentDeploy cd = cdPool.get(0);
				mh.resultHandler(cd);
				//放掉的水移除了
				cdPool.remove(0);
				count=0;
			}else{
				//如果池子没有水，等待放水
				//如果看了200次还没有水
				if(count == 200){
					//对象注销
					sp = null;
					//结束循环
					break;
				}
				try {
					//过50毫秒后再看看水池有没有水
					sleep(50);
					//次数+1
					count++;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
