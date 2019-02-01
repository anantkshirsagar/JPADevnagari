package com.devnagari;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StoreDevnagari {
	public static void main(String[] args) {
		if("जातो".equals("जातो"))
			System.out.println("OK");
		//StoreDevnagari.storeDevnagariData();
		//StoreDevnagari.retrieveDevnagariData();
	}

	public static void retrieveDevnagariData() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		DevnagariEntity employee = entitymanager.find(DevnagariEntity.class, 105);

		System.out.println("employee ID = " + employee.getId());
		System.out.println("employee NAME = " + employee.getDevnagariText());
	}

	public static void storeDevnagariData() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		DevnagariEntity devnagariEntity = new DevnagariEntity();
		devnagariEntity.setId(105);
		devnagariEntity.setDevnagariText("मी शाळेत जातो");
		
		entitymanager.persist(devnagariEntity);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}

/*
 * Not Useful
 * CREATE DATABASE `devnagari` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `devnagari`;

Use This to set table encoding properties ->
ALTER TABLE tablename CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

OR

CREATE DATABASE `devnagari` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `devnagari`;
*/
