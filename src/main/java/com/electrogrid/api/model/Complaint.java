package com.electrogrid.api.model;

public class Complaint {
	private int id;
	private String message;
	private int accountNumber;

	public Complaint() {

	}

	public Complaint(int id, String message, int accountNumber) {
		super();
		this.id = id;
		this.message = message;
		this.accountNumber = accountNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
}
