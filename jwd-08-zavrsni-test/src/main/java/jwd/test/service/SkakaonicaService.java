package jwd.test.service;

import java.util.List;

import jwd.test.model.Skakaonica;

public interface SkakaonicaService {
	
	List<Skakaonica> findAll();
	
	Skakaonica findOne(Long id);
	
	void save(Skakaonica skakaonica);

}
