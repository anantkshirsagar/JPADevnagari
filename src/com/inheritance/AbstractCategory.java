package com.inheritance;

import java.awt.Color;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract void setCategoryName(String categoryName);
	public abstract String getCategoryName();
	
	public abstract void setColor(Color color);
	public abstract Color getColor();
}