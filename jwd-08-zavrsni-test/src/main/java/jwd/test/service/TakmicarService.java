package jwd.test.service;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import jwd.test.model.Skok;
import jwd.test.model.Takmicar;

public interface TakmicarService {
	
	Page<Takmicar> findAll(int pageNum);
	
	Takmicar findOne(Long id);
	
	void save(Takmicar takmicar);
	
	Takmicar remove(Long id);

	Page<Takmicar> search (@Param("skakaonicaId") Long skakaonicaId, 
			@Param("imePrezime") String imePrezime, 
			@Param("drzava") String drzava,
			int pageNum);
	
}
