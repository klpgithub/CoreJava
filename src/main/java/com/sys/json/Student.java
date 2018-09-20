package com.sys.json;

import com.alibaba.fastjson.annotation.JSONField;

public class Student {

	/**
	 * 可以解决fastjson把bean转成json时把属性首字母小写的问题
	 */
	@JSONField(name = "NAME")
	private String NAME;
	@JSONField(name = "ID")
	private String ID;
	@JSONField(name = "SEX")
	private String SEX;
	@JSONField(name = "HOBBY")
	private String HOBBY;

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSEX() {
		return SEX;
	}

	public void setSEX(String sEX) {
		SEX = sEX;
	}

	public String getHOBBY() {
		return HOBBY;
	}

	public void setHOBBY(String hOBBY) {
		HOBBY = hOBBY;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String nAME, String iD, String sEX, String hOBBY) {
		super();
		NAME = nAME;
		ID = iD;
		SEX = sEX;
		HOBBY = hOBBY;
	}

}
