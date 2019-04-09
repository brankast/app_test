package jwd.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.test.model.Skakaonica;
import jwd.test.repository.SkakaonicaRepository;
import jwd.test.service.SkakaonicaService;

@Service
@Transactional
public class JpaSkakaonicaServiceImpl implements SkakaonicaService {
	
	@Autowired
	private SkakaonicaRepository skakaonicaRepository;

	@Override
	public List<Skakaonica> findAll() {
		
		return skakaonicaRepository.findAll();
	}

	@Override
	public Skakaonica findOne(Long id) {
		
		return skakaonicaRepository.findOne(id);
	}

	@Override
	public void save(Skakaonica skakaonica) {
		skakaonicaRepository.save(skakaonica);
		
	}

}
