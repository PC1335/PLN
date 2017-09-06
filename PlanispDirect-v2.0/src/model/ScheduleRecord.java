package model;
/*
 * 回看对象
 */
public class ScheduleRecord {
	private String s_contentid;//全局唯一标识
	private String s_physicalchannelid;//physicanlchannel在cms内的唯一标识 对应physicanlchannel的 contentid
	private String s_name;//名称
	private String s_startdate;//节目开播日期(yyyymmdd)
	private String s_starttime;//节目开播时间(hh24miss)
	private String s_duration;//节目时长(hh24miss)
	private String s_cpcontentid;//长下游双方约定的上游标示
	private String s_description;//描述信息
	private String s_domain;//发布到融合cdn时使用的域标识
	private String s_hotdegree;//发布到融合平台时队列优先级
	public String getS_contentid() {
		return s_contentid;
	}
	public void setS_contentid(String s_contentid) {
		this.s_contentid = s_contentid;
	}
	public String getS_physicalchannelid() {
		return s_physicalchannelid;
	}
	public void setS_physicalchannelid(String s_physicalchannelid) {
		this.s_physicalchannelid = s_physicalchannelid;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public String getS_startdate() {
		return s_startdate;
	}
	public ScheduleRecord() {
		super();
	}
	public void setS_startdate(String s_startdate) {
		this.s_startdate = s_startdate;
	}
	public String getS_starttime() {
		return s_starttime;
	}
	public void setS_starttime(String s_starttime) {
		this.s_starttime = s_starttime;
	}
	public String getS_duration() {
		return s_duration;
	}
	public void setS_duration(String s_duration) {
		this.s_duration = s_duration;
	}
	public String getS_cpcontentid() {
		return s_cpcontentid;
	}
	public void setS_cpcontentid(String s_cpcontentid) {
		this.s_cpcontentid = s_cpcontentid;
	}
	public String getS_description() {
		return s_description;
	}
	public void setS_description(String s_description) {
		this.s_description = s_description;
	}
	public String getS_domain() {
		return s_domain;
	}
	public void setS_domain(String s_domain) {
		this.s_domain = s_domain;
	}
	public String getS_hotdegree() {
		return s_hotdegree;
	}
	public void setS_hotdegree(String s_hotdegree) {
		this.s_hotdegree = s_hotdegree;
	}
}
