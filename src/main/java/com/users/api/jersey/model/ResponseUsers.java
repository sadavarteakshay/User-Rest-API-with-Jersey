package com.users.api.jersey.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ResponseUsers {

	
	@XmlElement(name = "ResponseUsers")
	List<Users> list=new ArrayList<>();

	public ResponseUsers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResponseUsers(List<Users> list) {
		super();
		this.list = list;
	}

	public List<Users> getList() {
		return list;
	}

	public void setList(List<Users> list) {
		this.list = list;
	}
	
	
	
	
}
