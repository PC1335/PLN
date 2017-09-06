package service;

import java.util.List; 

import model.Channel;
import model.PhysicalChannel;
import model.ScheduleRecord;

public interface IChannelService {
	public List<Channel> getCCTV();
	public List<Channel> getHD();
	public List<Channel> getTV();
	public Channel getChannel(String contentid);
	public List<PhysicalChannel> getPhysicalChannels(String contentid);
	public List<ScheduleRecord> getScheduleRecords(String contentid);
}
