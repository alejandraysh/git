package es.yosehacerlo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import es.yosehacerlo.dao.CountryDao;

@ContextConfiguration("classpath: **/applicationContext.xml")
public class pruebaSpring {
	@Autowired
	public static CountryDao cd;
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 cd = context.getBean(CountryDao.class);
		System.out.println(cd.getCountryByName("Spain").getName());
	}
}

 

