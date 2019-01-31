package com.devnagari;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class DevnagariEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String devnagariText;

	public DevnagariEntity(int id, String devnagariText) {
		this.id = id;
		this.setDevnagariText(devnagariText);
	}
	
	public DevnagariEntity() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDevnagariText() {
		return devnagariText;
	}

	public void setDevnagariText(String devnagariText) {
		this.devnagariText = devnagariText;
	}

	
}