package model;
/*
 * 图片对象
 */
public class Picture {
	private String p_contentid;//全局唯一标识
	private String p_fileurl;//图片文件url 标准ftp协议
	private String p_type;//图片类型
	private String p_description;//描述
	public String getP_contentid() {
		return p_contentid;
	}
	public void setP_contentid(String p_contentid) {
		this.p_contentid = p_contentid;
	}
	public String getP_fileurl() {
		return p_fileurl;
	}
	public void setP_fileurl(String p_fileurl) {
		this.p_fileurl = p_fileurl;
	}
	public Picture() {
		super();
	}
	public Picture(String p_contentid, String p_fileurl, String p_type,
			String p_description) {
		super();
		this.p_contentid = p_contentid;
		this.p_fileurl = p_fileurl;
		this.p_type = p_type;
		this.p_description = p_description;
	}
	public String getP_type() {
		return p_type;
	}
	public void setP_type(String p_type) {
		this.p_type = p_type;
	}
	public String getP_description() {
		return p_description;
	}
	public void setP_description(String p_description) {
		this.p_description = p_description;
	}
}
