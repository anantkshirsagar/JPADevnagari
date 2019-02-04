package com.relationship;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPADevnagari");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		// Create Department Entity
		Department department = new Department();
		department.setDeptName("Computer Deparatment");

		// Store Department
		entitymanager.persist(department);

		Employee employee1 = new Employee();
		employee1.setEname("Pranav Joshi");
		employee1.setDeg("Developer");
		employee1.setDepartment(department);

		Employee employee2 = new Employee();
		employee2.setEname("Suyog Shah");
		employee2.setDeg("Tester");
		employee2.setDepartment(department);

		entitymanager.persist(employee1);
		entitymanager.persist(employee2);

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
