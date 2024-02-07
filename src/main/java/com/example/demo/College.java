package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class College {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String location;
	private String name;
	private String user;
	
	
	
	
	public College() {
		super();
	}
	

	public College(Integer id, String location, String name, String user) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
		this.user = user;
	}


// Getters and Setters
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getuser() {
		return user;
	}

	public void setuser(String user) {
		this.user = user;
	}



	@Override
	public String toString() {
		return "College [id=" + id + ", location=" + location + ", name=" + name + ", user=" + user + " ]";
	}
	
	
	
}
