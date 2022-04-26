package com.jersy.bean;

public class PowerInterruptionUpdateBean {
	private static int interruptionid;
	private static int newdate;
	private static String newlocation;
	private String newdescription;
	public int getInterruptionid() {
		return interruptionid;
	}
	public  void setInterruptionid(int interruptionid) {
		PowerInterruptionUpdateBean.interruptionid = interruptionid;
	}
	public  int getNewdate() {
		return newdate;
	}
	public  void setNewdate(int newdate) {
		PowerInterruptionUpdateBean.newdate = newdate;
	}
	public  String getNewlocation() {
		return newlocation;
	}
	public  void setNewlocation(String newlocation) {
		PowerInterruptionUpdateBean.newlocation = newlocation;
	}
	public String getNewdescription() {
		return newdescription;
	}
	public void setNewdescription(String newdescription) {
		this.newdescription = newdescription;
	}
	
	
	
	
	
	

}
