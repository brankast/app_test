package jwd.test.service;

import java.util.List;

import jwd.test.model.Skok;

public interface SkokService {
	
	List<Skok> findAll();
	
	Skok findOne(Long id);
	
	void save(Skok skok);
	
	List<Skok> findByTakmicarId(Long id);
	
	Skok zbirPoena(Long skokId);

}
