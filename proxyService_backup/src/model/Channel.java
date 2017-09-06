package model;
/*
 * 频道对象
 */
public class Channel {
	private String c_contentid;//全局唯一标识
	private String c_channelnumber;//建议频道号
	private String c_name;//频道名称
	private String c_callsign;//台标名称
	private String c_timeshift;//时移标志
	private String c_type;//频道类型
	private String c_status;//状态标志
	private String c_starttime;//播放开始时间(hh24mi)
	private String c_endtime;//播放结束时间(hh24mi)
	private String c_tags;//终端引用类型
	private String c_cpcontentid;//长下游双方约定的上游标示
	private String c_storageduration;//存储时长，单位小时
	private String c_timeshiftduration;//默认时移时长, 单位分钟
	private String c_description;//描述信息
	private String c_country;//国家
	private String c_state;//州/省
	private String c_city;//城市
	private String c_zipcode;//邮编
	private String c_url;//web频道url，
	private String c_subtype;//当type为1(直播频道)
	private String c_language;//语言
	private String c_macrovision;//拷贝保护标志
	private String c_videotype;//视频参数
	private String c_audiotype;//音频参数
	private String c_streamtype;//码流标志
	private String c_bilingual;//双语标志(0/1)
	private String c_hotdegree;//发布到融合平台时队列优先级
	public String getC_contentid() {
		return c_contentid;
	}
	public void setC_contentid(String c_contentid) {
		this.c_contentid = c_contentid;
	}
	public String getC_channelnumber() {
		return c_channelnumber;
	}
	public void setC_channelnumber(String c_channelnumber) {
		this.c_channelnumber = c_channelnumber;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_callsign() {
		return c_callsign;
	}
	public void setC_callsign(String c_callsign) {
		this.c_callsign = c_callsign;
	}
	public String getC_timeshift() {
		return c_timeshift;
	}
	public void setC_timeshift(String c_timeshift) {
		this.c_timeshift = c_timeshift;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_status() {
		return c_status;
	}
	public void setC_status(String c_status) {
		this.c_status = c_status;
	}
	public String getC_starttime() {
		return c_starttime;
	}
	public void setC_starttime(String c_starttime) {
		this.c_starttime = c_starttime;
	}
	public String getC_endtime() {
		return c_endtime;
	}
	public void setC_endtime(String c_endtime) {
		this.c_endtime = c_endtime;
	}
	public String getC_tags() {
		return c_tags;
	}
	public void setC_tags3(String c_tags) {
		this.c_tags = c_tags;
	}
	public String getC_cpcontentid() {
		return c_cpcontentid;
	}
	public void setC_cpcontentid(String c_cpcontentid) {
		this.c_cpcontentid = c_cpcontentid;
	}
	public String getC_storageduration() {
		return c_storageduration;
	}
	public void setC_storageduration(String c_storageduration) {
		this.c_storageduration = c_storageduration;
	}
	public String getC_timeshiftduration() {
		return c_timeshiftduration;
	}
	public void setC_timeshiftduration(String c_timeshiftduration) {
		this.c_timeshiftduration = c_timeshiftduration;
	}
	public String getC_description() {
		return c_description;
	}
	public void setC_description(String c_description) {
		this.c_description = c_description;
	}
	public String getC_country() {
		return c_country;
	}
	public void setC_country(String c_country) {
		this.c_country = c_country;
	}
	public String getC_state() {
		return c_state;
	}
	public void setC_state(String c_state) {
		this.c_state = c_state;
	}
	public String getC_city() {
		return c_city;
	}
	public void setC_city(String c_city) {
		this.c_city = c_city;
	}
	public String getC_zipcode() {
		return c_zipcode;
	}
	public void setC_zipcode(String c_zipcode) {
		this.c_zipcode = c_zipcode;
	}
	public String getC_url() {
		return c_url;
	}
	public void setC_url(String c_url) {
		this.c_url = c_url;
	}
	public String getC_subtype() {
		return c_subtype;
	}
	public void setC_subtype(String c_subtype) {
		this.c_subtype = c_subtype;
	}
	public String getC_language() {
		return c_language;
	}
	public void setC_language(String c_language) {
		this.c_language = c_language;
	}
	public String getC_macrovision() {
		return c_macrovision;
	}
	public void setC_macrovision(String c_macrovision) {
		this.c_macrovision = c_macrovision;
	}
	public String getC_videotype() {
		return c_videotype;
	}
	public void setC_videotype(String c_videotype) {
		this.c_videotype = c_videotype;
	}
	public String getC_audiotype() {
		return c_audiotype;
	}
	public void setC_audiotype(String c_audiotype) {
		this.c_audiotype = c_audiotype;
	}
	public String getC_streamtype() {
		return c_streamtype;
	}
	public void setC_streamtype(String c_streamtype) {
		this.c_streamtype = c_streamtype;
	}
	public String getC_bilingual() {
		return c_bilingual;
	}
	public void setC_bilingual(String c_bilingual) {
		this.c_bilingual = c_bilingual;
	}
	public String getC_hotdegree() {
		return c_hotdegree;
	}
	public void setC_hotdegree(String c_hotdegree) {
		this.c_hotdegree = c_hotdegree;
	}
	public Channel() {
		super();
	}
}
