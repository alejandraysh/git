package es.yosehacerlo.dao;

import java.util.List;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
 




import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.yosehacerlo.jpa.Country;
 
 
@Repository
public class CountryDaoImpl implements CountryDao
{
    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
	public void addAll(List<Country> list) {
		   for(Country country : list)
	        {
	            entityManager.persist(country);
	        }    
		
	}

	public Country getCountryByName(String name) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	      CriteriaQuery<Country> query = cb.createQuery(Country.class);
	 
	      Root<Country> country = query.from(Country.class);
	      query.where(cb.equal(country.<String>get("name"),
	      cb.parameter(String.class, "param")));
	 
	      TypedQuery<Country> tq = entityManager.createQuery(query);
	      tq.setParameter("param", name);
	      return tq.getResultList().get(0);
	}
@Transactional
	public void deleteAll() {
		  entityManager.createQuery("DELETE FROM Country").executeUpdate();   
		
	}

	public List<Country> getAll() {
		 Query query = entityManager.createQuery("from " + Country.class.getName());
	     return query.getResultList();
	}

	public Country getById(Long id) {
		return entityManager.find(Country.class, id);
		
	}
 
   
}