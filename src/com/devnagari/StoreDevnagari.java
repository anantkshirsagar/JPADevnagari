package com.devnagari;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StoreDevnagari {
	public static void main(String[] args) {
		StoreDevnagari.storeDevnagariData();
		StoreDevnagari.retrieveDevnagariData();
		StoreDevnagari.fetchList();
	}

	public static void fetchList() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		List<DevnagariEntity> devnagriEntity = entitymanager
				.createQuery("SELECT d FROM DevnagariEntity d", DevnagariEntity.class).getResultList();
		System.out.println("List=>");
		for (DevnagariEntity devnagariEntity : devnagriEntity) {
			System.out.println("ID=>" + devnagariEntity.getId());
			System.out.println("Test=>" + devnagariEntity.getDevnagariText());
		}
	}

	public static void retrieveDevnagariData() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		DevnagariEntity employee = entitymanager.find(DevnagariEntity.class, 106);

		System.out.println("employee ID = " + employee.getId());
		System.out.println("employee NAME = " + employee.getDevnagariText());
	}

	public static void storeDevnagariData() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		DevnagariEntity devnagariEntity = new DevnagariEntity();
		//devnagariEntity.setId(106);
		devnagariEntity.setDevnagariText("शाळेत जातो");

		entitymanager.persist(devnagariEntity);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}

/*
 * Not Useful CREATE DATABASE `devnagari` DEFAULT CHARACTER SET utf8 COLLATE
 * utf8_general_ci; USE `devnagari`;
 * 
 * Use This to set table encoding properties -> ALTER TABLE tablename CONVERT TO
 * CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
 * 
 * OR
 * 
 * CREATE DATABASE `devnagari` DEFAULT CHARACTER SET utf8mb4 COLLATE
 * utf8mb4_unicode_ci; USE `devnagari`;=>this works fine no need to mention
 * uncoding in mysql url
 * 
 * 
 * 
 * ALTER TABLE MY_TABLE MODIFY COLUMN id INT auto_increment;
 * for autoincrement of id
 */
