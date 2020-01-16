package com.everis.helpers;

public class MessageConfirmation {
	String msg;
	boolean test;
	
	
	public MessageConfirmation() {
		super();
	}

	public MessageConfirmation(String msg, boolean test) {
		super();
		this.msg = msg;
		this.test = test;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}
	
	
}
