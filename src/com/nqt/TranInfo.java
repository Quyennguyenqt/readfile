package com.nqt;

public class TranInfo {
	private long tranfer;
	private String date;
	private String code;
	
	public TranInfo() {
	}

	public TranInfo(long tranfer, String date, String code) {
		super();
		this.tranfer = tranfer;
		this.date = date;
		this.code = code;
	}

	public float getTranfer() {
		return tranfer;
	}

	public void setTranfer(long tranfer) {
		this.tranfer = tranfer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "TranInfo [tranfer=" + tranfer + ", date=" + date + ", code=" + code + "]";
	}

}
