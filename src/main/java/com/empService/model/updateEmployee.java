package com.model;

public class updateEmployee {
	
	private static int empID;
	private static String newempName;
	private static double newsalary;
	private static String newgender;
	private static int newcontact;
	private static String newdepartment;
	private static String newjoined_date;
	
	public static int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		updateEmployee.empID = empID;
	}
	
	public static String getNewempName() {
		return newempName;
	}
	public void setEmpName(String newempName) {
		updateEmployee.newempName = newempName;
	}
	
	public static Double getNewsalary() {
		return newsalary;
	}
	public void setNewsalary(Double newsalary) {
		updateEmployee.newsalary = newsalary;
	}
	
	public static String getNewgender() {
		return newgender;
	}
	public void setNewgender(String newgender) {
		updateEmployee.newgender = newgender;
	}
	
	public static int getNewcontact() {
		return newcontact;
	}
	public void setNewcontact(int newcontact) {
		updateEmployee.newcontact = newcontact;
	}
	
	public static String getNewdepartment() {
		return newdepartment;
	}
	public void setNewdepartment(String newdepartment) {
		updateEmployee.newdepartment = newdepartment;
	}
	
	public static String getNewjoined_date() {
		return newjoined_date;
	}
	public void setNewjoined_date(String newjoined_date) {
		updateEmployee.newjoined_date = newjoined_date;
	}

}
