package com.categorylist;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Category extends AbstractCategory {
	private String categoryName;
	private List<String> keywordsList;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getKeywordsList() {
		return keywordsList;
	}

	public void setKeywordsList(List<String> keywordsList) {
		this.keywordsList = keywordsList;
	}
}
