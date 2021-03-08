package com.bin.connect.diexam01;

public class UserBean {
	/*
	 * 1) 기본생성자를 가지고 있습니다. 
	 * 2) 필드는 private하게 선언합니다. 
	 * 3) getter, setter 메소드를 가집니다.
	 * 		getName() setName() 메소드를 name 프로퍼티(property)라고 합니다. (용어 중요)
	 *
	 * 나 대신 제어 해주기 위해서는 규칙을 따라야한다.
	 */
	private String name;
	private int age;
	private boolean male;
 
	public UserBean() {
	}

	public UserBean(String name, int age, boolean male) {
		super();
		this.name = name;
		this.age = age;
		this.male = male;
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

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

}
