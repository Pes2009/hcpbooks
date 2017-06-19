package com.sap.cloud.sample.persistence;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Session Bean implementation class PersonBean
 */
@Stateless
@LocalBean
public class PersonBean {
	
//	@Resource(lookup ="java:comp/env/jdbc/DefaultDB")
//	private DataSource dataSource;

	@PersistenceContext(unitName = "DefaultDB")
	private EntityManager em;

	public List<Person> getAllPersons() {
		return em.createNamedQuery("AllPersons").getResultList();

	}

	public void addPerson(Person person) {
		em.persist(person);
		em.flush();
	}
}