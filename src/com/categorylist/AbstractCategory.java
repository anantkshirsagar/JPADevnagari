package com.categorylist;

import java.util.List;

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
	
	public abstract void setKeywordsList(List<String> keywordsList);
	public abstract List<String> getKeywordsList();
	
	public abstract void setCategoryName(String categoryName);
	public abstract String getCategoryName();
}