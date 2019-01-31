package com.devnagari;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StoreDevnagari {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		DevnagariEntity devnagariEntity = new DevnagariEntity();
		devnagariEntity.setId(101);
		devnagariEntity.setDevnagariText("मी शाळेत जातो");

		entitymanager.persist(devnagariEntity);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}
}
