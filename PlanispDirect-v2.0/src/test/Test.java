package test;

import java.util.List;

import model.Channel;
import model.ScheduleRecord;
import dao.IDao;
import dao.impl.DaoImpl;
import service.IChannelService;
import service.impl.ChannelServiceImpl;
import utils.SortUtil;

public class Test {
	public static void main(String[] args){
		IDao dao = new DaoImpl();
		List<Channel> list = dao.queryChannls();
		for (Channel channel : list) {
			System.out.println(channel.getC_name());
		}
	}
}
