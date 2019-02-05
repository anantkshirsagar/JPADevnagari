package com.inheritance;

import java.awt.Color;

import javax.persistence.Entity;

@Entity
public class CategoryEntity extends AbstractCategory {
	private String categoryName;
	private Color color;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}