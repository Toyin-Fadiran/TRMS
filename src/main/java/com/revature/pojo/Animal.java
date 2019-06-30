package com.revature.pojo;

public class Animal {
	
	private String name;
	
	private String breed;
	
	private Integer age;
	
	private String owner;

	public Animal(String name, String breed, Integer age, String owner) {
		super();
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", breed=" + breed + ", age=" + age + ", owner=" + owner + "]";
	}
	

}
