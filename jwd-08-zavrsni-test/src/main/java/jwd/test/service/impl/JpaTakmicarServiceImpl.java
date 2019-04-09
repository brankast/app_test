package jwd.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.repository.SkokRepository;
import jwd.test.repository.TakmicarRepository;
import jwd.test.service.TakmicarService;

@Service
@Transactional
public class JpaTakmicarServiceImpl implements TakmicarService{
	
	@Autowired
	private TakmicarRepository takmicarRepository;
	@Autowired
	private SkokRepository skokRepository;

	@Override
	public Page<Takmicar> findAll(int pageNum) {
		
		return takmicarRepository.findAll(new PageRequest(pageNum, 5));
	}

	@Override
	public Takmicar findOne(Long id) {
		
		return takmicarRepository.findOne(id);
	}

	@Override
	public void save(Takmicar takmicar) {
		takmicarRepository.save(takmicar);
		
	}

	@Override
	public Takmicar remove(Long id) {
		Takmicar takmicar = takmicarRepository.findOne(id);
		if (takmicar != null) {
		takmicarRepository.delete(takmicar);
		}
		return takmicar;
	}

	@Override
	public Page<Takmicar> search(Long skakaonicaId, String imePrezime, String drzava, int pageNum) {
		
		return takmicarRepository.pretraga(skakaonicaId, imePrezime, drzava, new PageRequest(pageNum, 5));
	}


}
