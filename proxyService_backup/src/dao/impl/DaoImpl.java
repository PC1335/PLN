package dao.impl;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.contentdeployresult.iptv.ContentDeployResult;
import org.contentdeployresult.iptv.ContentDeployResultResponse;
import org.contentdeployresult.iptv.ContentDeployResultService;
import org.contentdeployresult.iptv.ContentDeployResultServiceLocator;

import utils.BaseDao;
import model.Channel;
import model.Mapping;
import model.PhysicalChannel;
import model.Picture;
import model.ScheduleRecord;
import dao.IDao;

public class DaoImpl extends BaseDao implements IDao {
	String sql;
	/*
	 * 注册频道
	 * @see dao.IDao#registChannel(model.Channel)
	 */
	@Override
	public void registChannel(Channel c) {
		sql = "insert into channel (c_contentid,c_channelnumber,c_name,"
				+ "c_callsign,c_timeshift,c_type,c_status,c_starttime,"
				+ "c_endtime,c_tags,c_cpcontentid,c_storageduration,"
				+ "c_timeshiftduration,c_description,c_country,c_state,"
				+ "c_city,c_zipcode,c_url,c_subtype,c_language,c_macrovision,"
				+ "c_videotype,c_audiotype,c_streamtype,c_bilingual,c_hotdegree)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		super.baseUpdate(sql, c.getC_contentid(), c.getC_channelnumber(), c.getC_name(), c.getC_callsign(), 
				c.getC_timeshift(), c.getC_type(), c.getC_status(), c.getC_starttime(), c.getC_endtime(), c.getC_tags(),
				c.getC_cpcontentid(), c.getC_storageduration(), c.getC_timeshiftduration(), c.getC_description(), 
				c.getC_country(), c.getC_state(), c.getC_city(), c.getC_zipcode(), c.getC_url(), c.getC_subtype(),
				c.getC_language(), c.getC_macrovision(), c.getC_videotype(), c.getC_audiotype(), c.getC_streamtype(),
				c.getC_bilingual(), c.getC_hotdegree());
	}
	/*
	 * 更新
	 * 如果不存在则转向注册
	 * @see dao.IDao#updateChannel(model.Channel)
	 */
	@Override
	public void updateChannel(Channel c) {
		sql = "select count(*) from channel where c_contentid = ?";
		int count = super.baseQueryForCount(sql, c.getC_contentid());
		if(count>=1){
			sql = "update channel set c_channelnumber = ?,c_name = ?,"
				+ "c_callsign = ?,c_timeshift = ?,c_type = ?,c_status = ?,c_starttime = ?,"
				+ "c_endtime = ?,c_tags = ?,c_cpcontentid = ?,c_storageduration = ?,"
				+ "c_timeshiftduration = ?,c_description = ?,c_country = ?,c_state = ?,"
				+ "c_city = ?,c_zipcode = ?,c_url = ?,c_subtype = ?,c_language = ?,c_macrovision = ?,"
				+ "c_videotype = ?,c_audiotype = ?,c_streamtype = ?,c_bilingual = ?,c_hotdegree = ? "
				+ "where c_contentid = ?";
			super.baseUpdate(sql,  c.getC_channelnumber(), c.getC_name(), c.getC_callsign(), 
				c.getC_timeshift(), c.getC_type(), c.getC_status(), c.getC_starttime(), c.getC_endtime(), c.getC_tags(),
				c.getC_cpcontentid(), c.getC_storageduration(), c.getC_timeshiftduration(), c.getC_description(), 
				c.getC_country(), c.getC_state(), c.getC_city(), c.getC_zipcode(), c.getC_url(), c.getC_subtype(),
				c.getC_language(), c.getC_macrovision(), c.getC_videotype(), c.getC_audiotype(), c.getC_streamtype(),
				c.getC_bilingual(), c.getC_hotdegree(),c.getC_contentid());
		}else{
			this.registChannel(c);			
		}
	}
	/*
	 * 删除
	 * @see dao.IDao#deleteChannel(model.Channel)
	 */
	@Override
	public void deleteChannel(Channel c) {
		sql = "delete from channel where c_contentid = ?";
		super.baseUpdate(sql, c.getC_contentid());
	}
	/*
	 * 删除
	 * @see dao.IDao#registPicture(model.Picture)
	 */
	@Override
	public void registPicture(Picture p) {
		sql = "insert into picture (p_contentid,p_fileurl,p_type,p_description)values(?,?,?,?)";
		super.baseUpdate(sql, p.getP_contentid(),p.getP_fileurl(),p.getP_type(),p.getP_description());
	}
	/*
	 * 更新图片对象
	 * 如果不存在则转向注册
	 * @see dao.IDao#updatePicture(model.Picture)
	 */
	@Override
	public void updatePicture(Picture p) {
		sql = "select count(*) from picture where p_contentid = ?";
		int count = super.baseQueryForCount(sql, p.getP_contentid());
		if(count>=1){
			sql = "update picture set p_fileurl = ?,p_type = ?,p_description = ? where p_contentid = ?";
			super.baseUpdate(sql, p.getP_fileurl(),p.getP_type(),p.getP_description(),p.getP_contentid());
		}else{
			this.registPicture(p);
		}
	}
	/*
	 * 删除
	 * @see dao.IDao#deletePicture(model.Picture)
	 */
	@Override
	public void deletePicture(Picture p) {
		sql = "delete from picture where p_contentid = ?";
		super.baseUpdate(sql, p.getP_contentid());
	}
	/*
	 * 注册回看对象
	 * @see dao.IDao#registScheduleRecord(model.ScheduleRecord)
	 */
	@Override
	public void registScheduleRecord(ScheduleRecord sr) {
		sql = "insert into schedulerecord (s_contentid,s_physicalchannelid,"
				+ "s_name,s_startdate,s_starttime,s_duration,s_cpcontentid,"
				+ "s_description,s_domain,s_hotdegree)values(?,?,?,?,?,?,?,?,?,?)";
		super.baseUpdate(sql, sr.getS_contentid(),sr.getS_physicalchannelid(),
				sr.getS_name(),sr.getS_startdate(),sr.getS_starttime(),sr.getS_duration(),
				sr.getS_cpcontentid(),sr.getS_description(),sr.getS_domain(),sr.getS_hotdegree());
	}
	/*
	 * 更新
	 * 如果不存在则更新
	 * @see dao.IDao#updateScheduleRecord(model.ScheduleRecord)
	 */
	@Override
	public void updateScheduleRecord(ScheduleRecord sr) {
		sql = "select count(*) from schedulerecord where s_contentid = ?";
		int count = super.baseQueryForCount(sql, sr.getS_contentid());
		if(count>=1){
			sql = "update schedulerecord set s_physicalchannelid = ?,s_name = ?,"
					+ "s_startdate = ?,s_starttime = ?,s_duration = ?,s_cpcontentid = ?,"
					+ "s_description = ?,s_domain = ?,s_hotdegree = ? where s_contentid = ?";
			super.baseUpdate(sql,sr.getS_physicalchannelid(),sr.getS_name(),sr.getS_startdate(),
					sr.getS_starttime(),sr.getS_duration(),sr.getS_cpcontentid(),sr.getS_description(),
					sr.getS_domain(),sr.getS_hotdegree(), sr.getS_contentid());
		}else{
			this.registScheduleRecord(sr);
		}
	}
	/*
	 * 删除(non-Javadoc)
	 * @see dao.IDao#deleteScheduleRecord(model.ScheduleRecord)
	 */
	@Override
	public void deleteScheduleRecord(ScheduleRecord sr) {
		sql = "delete from schedulerecord where s_contentid = ?";
		super.baseUpdate(sql, sr.getS_contentid());
	}
	/*
	 * 注册直播源对象(non-Javadoc)
	 * @see dao.IDao#registPhysicalChannel(model.PhysicalChannel)
	 */
	@Override
	public void registPhysicalChannel(PhysicalChannel pc) {
		sql = "insert into physicalchannel (p_contentid,p_destcasttype,"
				+ "p_srccasttype,p_bitratetype,p_tags,p_cpcontentid,p_multicastip,"
				+ "p_multicastport,p_unicasturl,p_videotype,p_audiotype,p_resolution,"
				+ "p_videoprofile,p_systemlayer,p_domain,p_hotdegree)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		super.baseUpdate(sql, pc.getP_contentid(),pc.getP_destcasttype(),pc.getP_srccasttype(),
				pc.getP_bitratetype(),pc.getP_tags(),pc.getP_cpcontentid(),pc.getP_multicastip(),
				pc.getP_multicastport(),pc.getP_unicasturl(),pc.getP_videotype(),pc.getP_audiotype(),
				pc.getP_resolution(),pc.getP_videoprofile(),pc.getP_systemlayer(),pc.getP_domain(),
				pc.getP_hotdegree());
	}
	/*
	 * 更新
	 * 如果不存在则注册(non-Javadoc)
	 * @see dao.IDao#updatePhysicalChannel(model.PhysicalChannel)
	 */
	@Override
	public void updatePhysicalChannel(PhysicalChannel pc) {
		sql = "select count(*) from physicalchannel where p_contentid = ?";
		int count = super.baseQueryForCount(sql, pc.getP_contentid());
		if(count>=1){
			sql = "update physicalchannel set p_destcasttype = ?,p_srccasttype = ?,"
					+ "p_bitratetype = ?,p_tags = ?,p_cpcontentid = ?,p_multicastip = ?,"
					+ "p_multicastport = ?,p_unicasturl = ?,p_videotype = ?,p_audiotype = ?,"
					+ "p_resolution = ?,p_videoprofile = ?,p_systemlayer = ?,p_domain = ?,"
					+ "p_hotdegree = ? where p_contentid = ?";
			super.baseUpdate(sql, pc.getP_destcasttype(),pc.getP_srccasttype(),
				pc.getP_bitratetype(),pc.getP_tags(),pc.getP_cpcontentid(),pc.getP_multicastip(),
				pc.getP_multicastport(),pc.getP_unicasturl(),pc.getP_videotype(),pc.getP_audiotype(),
				pc.getP_resolution(),pc.getP_videoprofile(),pc.getP_systemlayer(),pc.getP_domain(),
				pc.getP_hotdegree(),pc.getP_contentid());
		}else{
			this.registPhysicalChannel(pc);
		}
	}
	/*
	 * 删除(non-Javadoc)
	 * @see dao.IDao#deletePhysicalChannel(model.PhysicalChannel)
	 */
	@Override
	public void deletePhysicalChannel(PhysicalChannel pc) {
		sql = "delete from physicalchannel where p_contentid = ?";
		super.baseUpdate(sql, pc.getP_contentid());
	}
	/*
	 * 添加映射关系(non-Javadoc)
	 * @see dao.IDao#registMapping(model.Mapping)
	 */
	@Override
	public void registMapping(Mapping m) {
		sql = "insert into mapping (parenttype,elementtype,parentid,"
				+ "elementid,parentcode,elementcode,type,sequence,validstart,"
				+ "validend)values(?,?,?,?,?,?,?,?,?,?)";
		super.baseUpdate(sql, m.getParenttype(),m.getElementtype(),m.getParentid(),
				m.getElementid(),m.getParentcode(),m.getElementcode(),m.getType(),
				m.getSequence(),m.getValidstart(),m.getValidend());
	}
	/*
	 * 删除映射关系(non-Javadoc)
	 * @see dao.IDao#deleteMapping(model.Mapping)
	 */

	@Override
	public void deleteMapping(Mapping m) {
		sql = "delete from mapping where parentid = ? and elementid = ?";
		super.baseUpdate(sql, m.getParentid(),m.getElementid());
	}
	/*
	 * 将视科达封装的异步传输方法打包
	 * @see dao.IDao#response(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String)
	 */
	@Override
	public void response(String CMSID, String SOPID, String correlateID,
			int resultCode, String errorDescription, String resultFileURL) {
		try {
			ContentDeployResultService service = new ContentDeployResultServiceLocator();
			ContentDeployResult result = service.getContentDeployResult();
			ContentDeployResultResponse response = result.contentDeployResult("pln_live", "starcor", correlateID, resultCode, errorDescription,null);
		} catch (ServiceException e) {
		} catch (RemoteException e) {
		}
	}
}
