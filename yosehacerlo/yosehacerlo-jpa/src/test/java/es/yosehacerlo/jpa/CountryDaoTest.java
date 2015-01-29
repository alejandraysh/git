package es.yosehacerlo.jpa;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;
 



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import es.yosehacerlo.dao.CountryDao;
 

/**
 * Some test cases.
 * 
 * @author 
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class CountryDaoTest
{
 
    @Autowired
    public CountryDao countryDao;
 
    @Before
    @Transactional
    public void setUp() throws Exception
    {
        // empty repository
    	
      //  countryDao.deleteAll();
 
        List<Country> countries = new LinkedList<Country>();
        countries =  countryDao.getAll();
        countryDao.deleteAll();
        
        countryDao.addAll(countries);
    }
 
    @Test
    public void testCountryDao()
    {	
        assertEquals(countryDao.getAll().size(), 50);
     Country country = countryDao.getCountryByName("China");
        assertEquals(country.getName(), "China");
       
    }
 
    
    
    
}