package com.samtech.HelloWorld.beans;

public class Persion {
	private String name;
	private int age;
	private int id;
	
	public Persion(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
