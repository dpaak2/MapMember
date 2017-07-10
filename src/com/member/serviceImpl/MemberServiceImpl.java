package com.member.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.member.domain.MemberBean;
import com.member.service.MemberService;

public class MemberServiceImpl implements MemberService {
	MemberBean member;
	Map<String,MemberBean> map; //key 값은 String으로 주고 object(instance) = MemberBean이다
	List<MemberBean> list;

	public MemberServiceImpl() {
		member = new MemberBean(); 
		map = new HashMap<>(); //key값들은 hashCode이다 
		// 방 개수를 만들어주고
		list= new ArrayList<>();
	}

	@Override
	public void addMember(MemberBean bean) {
		map.put(bean.getId(), bean);
	}

	@Override
	public int countMembers() {
		return map.size(); // memberList.length;
	}

	@Override
	public List<MemberBean> getMembers() {
		Set<String>keys=map.keySet(); // **keys = id값들만 모아 놓은것들 
		for(String s: keys){//keys id의 집합체 안에 s= id값 key 하나의 값 so that key in keys
			list.add(map.get(s));
		}
		return list; //ArrayList가 된다 
	}

	@Override
	public MemberBean findById(String id) {
		return map.get(id);
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> nameList = new ArrayList<>();
		Set<String>keys=map.keySet(); 
		for(String s: keys){
			if(name.equals(map.get(s).getId())){
				nameList.add(map.get(s));
			}
		}
		System.out.println("serviceImpl: "+nameList.toString());
		return nameList;
	}

	@Override
	public void updateProfile(MemberBean bean) {
		//findById(bean.getPw()).setPw(bean.getPw());
	   
		MemberBean mem = findById(bean.getId());
	
			if(!bean.getName().equals("")){
				mem.setName(bean.getName());
			}
			if(!bean.getPw().equals("")){
				mem.setPw(bean.getPw());
			}
			if(!bean.getSsn().equals("")){
				mem.setSsn(bean.getSsn());
			}
			System.out.println("serviceImpl*****"+mem.toString());
	}

	@Override
	public void deleteUser(String id) {
		for (MemberBean m : list) {
			if (id.equals(m.getId())) {
				// list.get(i)=list[count-1];
				map.remove(id);
				break;
			}
		}
		// list.get(i)=null;
		// count--;
	}

}