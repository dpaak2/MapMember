package com.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.member.constants.Butt;
import com.member.domain.MemberBean;
import com.member.service.MemberService;
import com.member.serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		MemberService service = new MemberServiceImpl();
		MemberBean bean = null;
		// EXIT,ADD,LIST,FIND_NAME,FIND_ID,COUNT,UPDATE,DEL;
		Butt[] buttons = { Butt.EXIT, Butt.ADD, Butt.COUNT, Butt.LIST, Butt.FIND_ID, Butt.FIND_NAME, Butt.UPDATE,
				Butt.DEL };
		do {
			flag: switch ((Butt) JOptionPane.showInputDialog(null, // frame
					"MEMBER ADMIN", // frame title
					"SELECT MENU", // order
					JOptionPane.QUESTION_MESSAGE, // type
					null, // icon
					buttons, // Array of choices
					buttons[1] /* default */
			)) {
			case EXIT:
				JOptionPane.showMessageDialog(null, "Admin service close");
				return;
			case ADD:
				bean= new MemberBean();
				bean.setName(JOptionPane.showInputDialog("name"));
				bean.setId(JOptionPane.showInputDialog("ID"));
				bean.setPw(JOptionPane.showInputDialog("PassWord"));
				bean.setSsn(JOptionPane.showInputDialog("SSN"));
				service.addMember(bean);
				System.out.println("controller==" + bean.toString());
				JOptionPane.showMessageDialog(null, "회원 가입 성공");
				break flag;
			case COUNT:
				JOptionPane.showMessageDialog(null, service.countMembers());
				break flag;

			case LIST:
				JOptionPane.showMessageDialog(null, service.getMembers());
				break flag;

			case FIND_ID:
				JOptionPane.showMessageDialog(null,service.findById(JOptionPane.showInputDialog("찾으실 ID로 검색하여 주세요")).toString());
				break flag;
			case FIND_NAME:
				String searchName = JOptionPane.showInputDialog("찾으실 이름으로 검색하여 주세요");
				List<MemberBean> members = service.findByName(searchName);
				JOptionPane.showMessageDialog(null, members);
				break;
			case UPDATE:
				bean = new MemberBean();
				bean.setId(JOptionPane.showInputDialog("로그인 아이디를 입력하여 주세요"));
				bean.setName(JOptionPane.showInputDialog("변경하실 이름을 입력하여 주세요"));
				bean.setPw(JOptionPane.showInputDialog("변경하실 비번을 입력하여 주세요"));
				bean.setSsn(JOptionPane.showInputDialog("변경하실 주민번호를 입력하여 주세요"));
				service.updateProfile(bean);
				JOptionPane.showMessageDialog(null, "프로필이 수정되었습니다.");
				break flag;
			case DEL:
				service.deleteUser(JOptionPane.showInputDialog("삭제하려는 아이디 를 입력하세요"));
				break flag;
			}
		} while (true);
	}
}