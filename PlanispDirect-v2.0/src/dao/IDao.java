package dao;

import java.util.List;

import model.Channel;
import model.PhysicalChannel;
import model.ScheduleRecord;

public interface IDao {
	public List<ScheduleRecord> queryRecord(String contentid,String date);
	public List<Channel> queryChannls();
	public Channel queryChannelById(String contentid);
	public List<PhysicalChannel> getPhysicalChannels(String contentid);
}
