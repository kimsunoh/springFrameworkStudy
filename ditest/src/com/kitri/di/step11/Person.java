package com.kitri.di.step11;

public class Person {
	private String name;
	private String id;
	private int money;
	private double weight;
	private Address address;
	
	public Person() {}

	public Person(String name) {
		super();
		this.name = name;
	}
	
	
	public Person(int money) {
		super();
		this.money = money;
	}

	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Person(String name, Address addressDto) {
		super();
		this.name = name;
		this.address = addressDto;
	}

	public Person(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public Person(String name, int money, double weight) {
		super();
		this.name = name;
		this.money = money;
		this.weight = weight;
	}

	public Person(String name, String id, int money, double weight) {
		super();
		this.name = name;
		this.id = id;
		this.money = money;
		this.weight = weight;
	}
	
	public Person(String name, String id, int money, double weight, Address addressDto) {
		super();
		this.name = name;
		this.id = id;
		this.money = money;
		this.weight = weight;
		this.address = addressDto;
	}

	
	public Person(int money, double weight) {
		super();
		this.money = money;
		this.weight = weight;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "이름:" +  name +"\t아이디:" + id + "\t몸무게:" + weight + "\t재산:" + money + "\t주소:" + address;
	}
}