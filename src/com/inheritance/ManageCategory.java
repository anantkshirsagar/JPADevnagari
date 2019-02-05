package com.inheritance;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.categorylist.Category;
import com.devnagari.DevnagariEntity;

public class ManageCategory {
	public static void main(String[] args) {
		//storeCategoryNameAndKeywordList();
		fetchCategoryNameAndKeywordList();
	}

	public static void storeCategoryNameAndKeywordList() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		com.categorylist.AbstractCategory category = new Category();
		category.setCategoryName("Location");
		List<String> keywordsList = new ArrayList<>();
		keywordsList.add("Pune");
		keywordsList.add("Mumbai");
		keywordsList.add("Solapur");
		category.setKeywordsList(keywordsList);
		
		entitymanager.persist(category);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
	
	public static void fetchCategoryNameAndKeywordList() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		List<Category> categoryList = entitymanager
				.createQuery("SELECT d FROM Category d", Category.class).getResultList();
		System.out.println("List=>");
		for (Category categoryEntity : categoryList) {
			System.out.println(" ID: =>" + categoryEntity.getId());
			System.out.println(" Category Name: =>" + categoryEntity.getCategoryName());
			List<String> keywords = categoryEntity.getKeywordsList();
			for (String string : keywords) {
				System.out.println(" Keyowrds: =>" +string);
			}
		}	
	}

	public static void storeCategoryEntity() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		//There are two AbstractCategory Class 
		/*AbstractCategory category1 = getCategoryEntity("Organisation", Color.RED);
		AbstractCategory category2 = getCategoryEntity("Person", Color.GREEN);
		AbstractCategory category3 = getCategoryEntity("Location", Color.BLUE);

		entitymanager.persist(category1);
		entitymanager.persist(category2);
		entitymanager.persist(category3);
		*/
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}

	/*
	public static AbstractCategory getCategoryEntity(String categoryName, Color color) {
		AbstractCategory category = new CategoryEntity();
		category.setCategoryName(categoryName);
		category.setColor(color);
		return category;
	}
	*/
}