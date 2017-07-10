package com.member.service;

import java.util.List;

import com.member.domain.MemberBean;

public interface MemberService {
	public void addMember(MemberBean bean);
	public List<MemberBean> getMembers();
	public int countMembers();
	//MemberBean[] list = new MemberBean[4];
	public MemberBean findById(String id);
	public List<MemberBean> findByName(String name);
	public void updateProfile(MemberBean bean);
	public void deleteUser(String id);
	
}
