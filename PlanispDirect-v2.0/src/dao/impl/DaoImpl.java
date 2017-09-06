package dao.impl;

import java.util.ArrayList;
import java.util.List;

import utils.BaseDao;
import model.Channel;
import model.PhysicalChannel;
import model.Picture;
import model.ScheduleRecord;
import dao.IDao;

public class DaoImpl extends BaseDao implements IDao {
	String sql ;
	/*
	 * 根据日期以及频道id查询回看
	 * @see dao.IDao#queryRecord(java.lang.String, java.lang.String)
	 */
	@Override
	public List<ScheduleRecord> queryRecord(String contentid,String date) {
		sql = "SELECT * FROM schedulerecord WHERE s_contentid in "
				+ "(SELECT elementid FROM mapping WHERE parentid = ? " 
				+ "AND parenttype = 'Channel' AND elementtype = 'ScheduleRecord') "
				+ "AND s_startdate = ? "
				+ "ORDER BY s_starttime+0 asc";
		return super.baseQuery(sql, ScheduleRecord.class,contentid,date);
	}
	/*
	 * 将所有频道查询出来
	 * @see dao.IDao#queryChannls()
	 */
	@Override
	public List<Channel> queryChannls() {
		sql = "select * from channel";
		return super.baseQuery(sql, Channel.class);
	}
	/*
	 * 根据id查询频道
	 * @see dao.IDao#queryChannelById(java.lang.String)
	 */
	@Override
	public Channel queryChannelById(String contentid) {
		sql = "select * from channel where c_contentid = ?";
		return super.baseQueryById(sql, Channel.class, contentid);
	}
	/*
	 * 查询直播源
	 * @see dao.IDao#getPhysicalChannels(java.lang.String)
	 */
	@Override
	public List<PhysicalChannel> getPhysicalChannels(String contentid) {
		sql = "SELECT * FROM physicalchannel WHERE p_contentid in (SELECT elementid FROM mapping WHERE parentid = ?)";
		return super.baseQuery(sql, PhysicalChannel.class, contentid);
	}
}
