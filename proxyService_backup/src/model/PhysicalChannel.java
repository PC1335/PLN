package model;
/*
 * 直播员对象
 */
public class PhysicalChannel {
	private String p_contentid;//全局唯一标识
	private String p_destcasttype;//用户访问改频道使用是单播还是组播。
	private String p_srccasttype;//cdn接收到的频道类型方式，可能是单播，也可能是组播。
	private String p_bitratetype;//码流:
	private String p_tags;//终端引用类型多个类型之间使用逗号分隔
	private String p_cpcontentid;//长下游双方约定的上游标示
	private String p_multicastip;//组播ip
	private String p_multicastport;//组播端口
	private String p_unicasturl;//单播地址
	private String p_videotype;//编码格式
	private String p_audiotype;//编码格式
	private String p_resolution;//分辨率类型
	private String p_videoprofile;//
	private String p_systemlayer;//文件格式
	private String p_domain;//发布到融合cdn时使用的域标识
	private String p_hotdegree;//发布到融合平台时队列优先级
	public String getP_contentid() {
		return p_contentid;
	}
	public void setP_contentid(String p_contentid) {
		this.p_contentid = p_contentid;
	}
	public PhysicalChannel() {
		super();
	}
	public String getP_destcasttype() {
		return p_destcasttype;
	}
	public void setP_destcasttype(String p_destcasttype) {
		this.p_destcasttype = p_destcasttype;
	}
	public String getP_srccasttype() {
		return p_srccasttype;
	}
	public void setP_srccasttype(String p_srccasttype) {
		this.p_srccasttype = p_srccasttype;
	}
	public String getP_bitratetype() {
		return p_bitratetype;
	}
	public void setP_bitratetype(String p_bitratetype) {
		this.p_bitratetype = p_bitratetype;
	}
	public String getP_tags() {
		return p_tags;
	}
	public void setP_tags(String p_tags) {
		this.p_tags = p_tags;
	}
	public String getP_cpcontentid() {
		return p_cpcontentid;
	}
	public void setP_cpcontentid(String p_cpcontentid) {
		this.p_cpcontentid = p_cpcontentid;
	}
	public String getP_multicastip() {
		return p_multicastip;
	}
	public void setP_multicastip(String p_multicastip) {
		this.p_multicastip = p_multicastip;
	}
	public String getP_multicastport() {
		return p_multicastport;
	}
	public void setP_multicastport(String p_multicastport) {
		this.p_multicastport = p_multicastport;
	}
	public String getP_unicasturl() {
		return p_unicasturl;
	}
	public void setP_unicasturl(String p_unicasturl) {
		this.p_unicasturl = p_unicasturl;
	}
	public String getP_videotype() {
		return p_videotype;
	}
	public void setP_videotype(String p_videotype) {
		this.p_videotype = p_videotype;
	}
	public String getP_audiotype() {
		return p_audiotype;
	}
	public void setP_audiotype(String p_audiotype) {
		this.p_audiotype = p_audiotype;
	}
	public String getP_resolution() {
		return p_resolution;
	}
	public void setP_resolution(String p_resolution) {
		this.p_resolution = p_resolution;
	}
	public String getP_videoprofile() {
		return p_videoprofile;
	}
	public void setP_videoprofile(String p_videoprofile) {
		this.p_videoprofile = p_videoprofile;
	}
	public String getP_systemlayer() {
		return p_systemlayer;
	}
	public void setP_systemlayer(String p_systemlayer) {
		this.p_systemlayer = p_systemlayer;
	}
	public String getP_domain() {
		return p_domain;
	}
	public void setP_domain(String p_domain) {
		this.p_domain = p_domain;
	}
	public String getP_hotdegree() {
		return p_hotdegree;
	}
	public void setP_hotdegree(String p_hotdegree) {
		this.p_hotdegree = p_hotdegree;
	}
}
