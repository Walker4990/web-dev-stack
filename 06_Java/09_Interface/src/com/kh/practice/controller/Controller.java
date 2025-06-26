package com.kh.practice.controller;

import java.time.LocalDate;

import com.kh.practice.model.*;

public class Controller {

	UserInfo info = new UserInfo();
	Department dept = new Department();

<<<<<<< Updated upstream
	private UserInfo[] userList = { new UserInfo(), new UserInfo(), new UserInfo() };

	private int count = 0;
	// 로그인 -> 유저정보 클라이언트한테 넘김
	public UserInfo login(String id, String password) {
		for(UserInfo user : userList) {
			if(id.equals(user.getUserId()) && password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}
	
	private UserInfo userInfo = new UserInfo();

//	public UserInfo getUser() {
//		return info;
//	}
//
//	public boolean login(String id, String password) {
//		return id.equals(info.getUserId()) && password.equals(info.getPassword());
//	}

//	public void inputInfo(int userNo, String userId, String password, String email, String name) {
//		info.setUserNo(userNo);
//		info.setUserId(userId);
//		info.setPassword(password);
//		info.setEmail(email);
//		info.setName(name);
//	}
	public void inputInfo(int userNo, String userId, String password, String email, String name) {
		userList[count].setUserNo(userNo);
		userList[count].setUserNo(userNo);
		userList[count].setUserId(userId);
		userList[count].setPassword(password);
		userList[count].setEmail(email);
		userList[count].setName(name);
		count++;
	}

	// 오버로딩 같은 이름의 메서드 (다른 갯수나 종류의 변수)
//	public void inputInfo(String phone, String addr, String gender, LocalDate birthDate, int deptNo, String deptName) {
//		info.setPhone(phone);
//		info.setAddr(addr);
//		info.setGender(gender);
//		info.setBirthDate(birthDate);
//		dept.setDeptNo(deptNo);
//		dept.setDeptName(deptName);
//	}
	
	public void inputInfo(String phone, String addr, String gender, LocalDate birthDate, Department department) {
		userList[count].setPhone(phone);
		userList[count].setAddr(addr);
		userList[count].setGender(gender);
		userList[count].setBirthDate(birthDate);
		// 기존에 있는 부서(해당 유저들)면 해당 부서 정보 그대로 추가
		for(UserInfo user : userList) {
			Department dept = user.getDepartment();
			if(dept != null && dept.getDeptName().equals(department.getDeptName())) {
				userList[count].setDepartment(dept);
				return;
			}
		}
		// 기존에 없는 부서 새로 추가
		department.setDeptNo(DeptType.findDeptNo(department.getDeptName()));
		userList[count].setDepartment(department);
		
	}
	// 메서드 케이스 별로 각각 분리
//	public void updateInfo(String phone) {
//		info.setPhone(phone);
//	}
//	public void updateInfo(LocalDate birthDate) {
//		info.setBirthDate(birthDate);
//	}
//	public void updateInfo(int deptNo, String deptName) {
//		dept.setDeptNo(deptNo);
//		dept.setDeptName(deptName);
//	}

	// 한개로 갈거면 클라이언트쪽에 저장되어있어야함.

//	public void updateUser(UserInfo info) {
//	
//		userInfo = info;
//	}
	public void updateUser(UserInfo info) {
		for(UserInfo user : userList) {
			if(user.getUserNo() == info.getUserNo()) {
				info = user;
			}
		}
	}
	
//	public void updateInfo(String phone, LocalDate birthDate, int deptNo, String deptName) {
//		info.setPhone(phone);
//		info.setBirthDate(birthDate);
//		dept.setDeptNo(deptNo);
//		dept.setDeptName(deptName);
//	}
=======
	public void inputInfo(int userNo, String userId, String password, String email, String name) {
		info.setUserNo(userNo);
		info.setUserId(userId);
		info.setPassword(password);
		info.setEmail(email);
		info.setName(name);
	}

	public void addInfo(String phone, String addr, String gender, LocalDate birthDate, int deptNo, String deptName) {
		info.setPhone(phone);
		info.setAddr(addr);
		info.setGender(gender);
		info.setBirthDate(birthDate);
		dept.setDeptNo(deptNo);
		dept.setDeptName(deptName);
	}
	
	public void updateInfo(String phone, LocalDate birthDate, int deptNo, String deptName) {
		info.setPhone(phone);
		info.setBirthDate(birthDate);
		dept.setDeptNo(deptNo);
		dept.setDeptName(deptName);
	}
>>>>>>> Stashed changes
}
