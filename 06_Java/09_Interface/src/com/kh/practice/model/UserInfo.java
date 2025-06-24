package com.kh.practice.model;

import java.time.LocalDate;

public class UserInfo {

	private int userNo;
	private String userId;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate birthDate;
	private Department department;
	
	public UserInfo() {
	}

	public UserInfo(int userNo, String userId, String password, String email, String name, String phone, String addr,
			String gender, LocalDate birthDate, Department department) {
		this.userNo = userNo;
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.gender = gender;
		this.birthDate = birthDate;
		this.department = department;
	}

	public int getUserNo() {
		return userNo;
	}

	public int setUserNo(int userNo) {
		return this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String setUserId(String userId) {
		return this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public String setPassword(String password) {
		return this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String setEmail(String email) {
		return this.email;
	}

	public String getName() {
		return name;
	}

	public String setName(String name) {
		return this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public String setPhone(String phone) {
		return this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public String setAddr(String addr) {
		return this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public String setGender(String gender) {
		return this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public LocalDate setBirthDate(LocalDate birthDate) {
		return this.birthDate = birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "UserInfo [userNo=" + userNo + ", userId=" + userId + ", password=" + password + ", email=" + email
				+ ", name=" + name + ", phone=" + phone + ", addr=" + addr + ", gender=" + gender + ", birthDate="
				+ birthDate + ", department=" + department + "]";
	}
	
	
}
