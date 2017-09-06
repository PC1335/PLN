package model;

public class Mapping {
	private String parenttype;
	private String elementtype;
	private String parentid;
	private String elementid;
	private String parentcode;
	private String elementcode;
	private String type;
	public String getElementcode() {
		return elementcode;
	}
	public void setElementcode(String elementcode) {
		this.elementcode = elementcode;
	}
	private String sequence;
	private String validstart;
	private String validend;
	public Mapping() {
		super();
	}
	public String getParenttype() {
		return parenttype;
	}
	public void setParenttype(String parenttype) {
		this.parenttype = parenttype;
	}
	public String getElementtype() {
		return elementtype;
	}
	public void setElementtype(String elementtype) {
		this.elementtype = elementtype;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getElementid() {
		return elementid;
	}
	public void setElementid(String elementid) {
		this.elementid = elementid;
	}
	public String getParentcode() {
		return parentcode;
	}
	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getValidstart() {
		return validstart;
	}
	public void setValidstart(String validstart) {
		this.validstart = validstart;
	}
	public String getValidend() {
		return validend;
	}
	public void setValidend(String validend) {
		this.validend = validend;
	}
}
