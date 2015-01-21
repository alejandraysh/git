package es.yosehacerlo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.test.context.ContextConfiguration;

public class prueba {

	public static void main(String[] args) {
		 City yo = new City();
		 yo.setName("Oviedo");
		 yo.setCountryCode("330");
		 yo.setDistrict("AST");
		 EntityManagerFactory emf =
		 Persistence.createEntityManagerFactory("World");
		 EntityManager em = emf.createEntityManager();
		 try {
		 em.getTransaction().begin();
		 em.persist(yo);
		 em.getTransaction().commit();
		 
		 
		 City ciudad = em.find(City.class, 4);
		 System.out.println(ciudad.getName());
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 Session session = em.unwrap(Session.class);
		 Criteria criteria = session.createCriteria(Country.class);
		 criteria.add(Restrictions.eq("name", "Spain"));
		 System.out.println(((Country) criteria.uniqueResult()).getName());
		 } catch (Exception e) {
		 
		 e.printStackTrace();
		 }finally {
		 em.close();
		 
		 }
		 }

	}

 

