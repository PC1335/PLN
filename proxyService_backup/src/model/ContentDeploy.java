package model;
/*
 * 自定义的javabean，存储传过来的值
 */
public class ContentDeploy {
	private String CMSID;
	private String SOPID; 
	private String correlateID;
	private String cmdFileURL;
	public ContentDeploy(String CMSID, String SOPID, String correlateID,
			String cmdFileURL) {
		super();
		this.CMSID = CMSID;
		this.SOPID = SOPID;
		this.correlateID = correlateID;
		this.cmdFileURL = cmdFileURL;
	}
	public String getCMSID() {
		return CMSID;
	}
	public void setCMSID(String cMSID) {
		CMSID = cMSID;
	}
	public String getSOPID() {
		return SOPID;
	}
	public void setSOPID(String sOPID) {
		SOPID = sOPID;
	}
	public String getCorrelateID() {
		return correlateID;
	}
	public void setCorrelateID(String correlateID) {
		this.correlateID = correlateID;
	}
	public String getCmdFileURL() {
		return cmdFileURL;
	}
	public void setCmdFileURL(String cmdFileURL) {
		this.cmdFileURL = cmdFileURL;
	}
}
