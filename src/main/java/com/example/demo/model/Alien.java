package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
	private int aid;
	private String aname;
	private String tech;

	
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public void setAname(String aname) {
		this.aname = aname;
	}

	public void setAtech(String tech) {
		this.tech = tech;
	}

	public int getAid() {
		return aid;
	}
	public String getAname() {
		return aname;
	}
	public String getAtech() {
		return tech;
	}
	
	
	
	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
	
	
}
