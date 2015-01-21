package es.yosehacerlo.dao;

import java.util.List;

import es.yosehacerlo.jpa.Country;

public interface CountryDao {

	void addAll(List<Country> list);

	Country getCountryByName(String name);

	void deleteAll();

	List<Country> getAll();

	Country getById(Long id);

}
