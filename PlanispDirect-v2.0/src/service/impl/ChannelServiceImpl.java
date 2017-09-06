package service.impl;

import java.util.ArrayList;  
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import dao.IDao;
import dao.impl.DaoImpl;
import model.Channel;
import model.PhysicalChannel;
import model.ScheduleRecord;
import service.IChannelService;

public class ChannelServiceImpl implements IChannelService {
	IDao dao = new DaoImpl();
	//类被加载后直接查询到所有的频道
	//筛选cctv
	@Override
	public List<Channel> getCCTV() {
		List<Channel> ls = new ArrayList<Channel>();
		for (Channel c : dao.queryChannls()) {
			if(c.getC_name().indexOf("CCTV")!=-1)
				ls.add(c);
		}
		return ls;
	}
	//筛选高清
	@Override
	public List<Channel> getHD() {
		List<Channel> ls = new ArrayList<Channel>();
		for (Channel c : dao.queryChannls()) {
			if((c.getC_name().endsWith("高清") && c.getC_name().indexOf("CCTV")==-1)||c.getC_name().indexOf("HD")!=-1)
				ls.add(c);
		}
		return ls;
	}
	//筛选卫视
	@Override
	public List<Channel> getTV() {
		List<Channel> ls = new ArrayList<Channel>();
		for (Channel c : dao.queryChannls()) {
			if(c.getC_name().indexOf("CCTV")==-1 && c.getC_name().indexOf("高清")==-1 && c.getC_name().indexOf("HD")==-1)
				ls.add(c);
		}
		return ls;
	}
	//根据id查找到频道
	@Override
	public Channel getChannel(String contentid) {
		return dao.queryChannelById(contentid);
	}
	//查找到直播源
	@Override
	public List<PhysicalChannel> getPhysicalChannels(String contentid) {
		return dao.getPhysicalChannels(contentid);
	}
	//查找回看
	@Override
	public List<ScheduleRecord> getScheduleRecords(String contentid) {
		List<ScheduleRecord> list = dao.queryRecord(contentid,getDate());
		for (ScheduleRecord sr : list) {
			String starttime = sr.getS_starttime();
			//修改starttime的格式
			String st = starttime.substring(0,2)+":"+starttime.substring(2,4);
			sr.setS_starttime(st);
		}
		return list;
	}
	//格式化当日日期
	public static String getDate(){
		Calendar a=Calendar.getInstance();
		 String year = a.get(Calendar.YEAR)+"";
		 String mounth = (a.get(Calendar.MONTH)+1)/10>=1? a.get(Calendar.MONTH)+1+"" : 0+""+(a.get(Calendar.MONTH)+1);
		 String day = a.get(Calendar.DAY_OF_MONTH)/10>=1? a.get(Calendar.DAY_OF_MONTH)+"" : 0+""+a.get(Calendar.DAY_OF_MONTH);
		 return year+mounth+day;
	}
	

}
