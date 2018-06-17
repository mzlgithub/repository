package com.yihuisort.entity;

import java.util.Date;

/**
 * 2018-1-31
 * @author 学生类
 *
 */
public class Student {
	private Integer id;
	private String name;
	private Date bornDate;
	
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public Student() {
		super();
	}
	
	public Student(String name, Date bornDate) {
		super();
		this.name = name;
		this.bornDate = bornDate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
