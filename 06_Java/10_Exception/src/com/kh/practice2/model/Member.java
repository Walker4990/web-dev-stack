package com.kh.practice2.model;

public class Member {

	private String id;
	private String name;
	private String pwd;
	private String email;
	private char gender;
	private int age;
	
	public Member() {
	}
	public Member(String id, String name, String pwd, String email, char gender, int age) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}
	public String getId() {
		return id;
	}
	public String setId(String id) {
		return this.id = id;
	}
	public String getName() {
		return name;
	}
	public String setName(String name) {
		return this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public String setPwd(String pwd) {
		return this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail(String email) {
		return this.email = email;
	}
	public char getGender() {
		return gender;
	}
	public char setGender(char gender) {
		return this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public int setAge(int age) {
		return this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pwd=" + pwd + ", email=" + email + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	
}
