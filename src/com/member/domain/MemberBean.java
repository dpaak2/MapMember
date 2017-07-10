package com.member.domain;


public class MemberBean {
	private String id, pw, ssn,name;


	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setSsn(String ssn) {
	
		this.ssn = ssn;
	}

	public String getSsn() {
		return ssn;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberBean [id=" + id + ", pw=" + pw + ", ssn=" + ssn + ", name=" + name + "] \n";
	}

	
}
