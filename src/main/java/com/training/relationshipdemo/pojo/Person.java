package com.training.relationshipdemo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Person {
	@Id
	private int pid;
	private String name;
	private String hobby;

   @ManyToMany(mappedBy = "listPerson")
	private List<Laptop> llist = new ArrayList<Laptop>();
	public List<Laptop> getLlist() {
		return llist;
	}
	public void setLlist(List<Laptop> llist) {
		this.llist = llist;
	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
