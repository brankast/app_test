package jwd.test.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.repository.SkokRepository;
import jwd.test.repository.TakmicarRepository;
import jwd.test.service.SkokService;

@Service
@Transactional
public class JpaSkokServiceImp implements SkokService {
	
	@Autowired
	private SkokRepository skokRepository;
	@Autowired
	private TakmicarRepository takmicarRepository;

	@Override
	public List<Skok> findAll() {
		
		return skokRepository.findAll();
	}

	@Override
	public Skok findOne(Long id) {
		
		return skokRepository.findOne(id);
	}

	@Override
	public void save(Skok skok) {
		skokRepository.save(skok);
		
	}

	@Override
	public List<Skok> findByTakmicarId(Long id) {
		
		return skokRepository.findByTakmicarId(id);
	}

	@Override
	public Skok zbirPoena(Long skokId) {
	
		Skok skok = skokRepository.findOne(skokId);
		
		if (skok.getDaljina() == skok.getTakmicar().getSkakaonica().getK()) {
			skok.setZbirPoena(60.0);
		} else if (skok.getDaljina() > skok.getTakmicar().getSkakaonica().getK()) {
			skok.setZbirPoena(60.0 + skok.getTakmicar().getSkakaonica().getD());
		} else if (skok.getDaljina() < skok.getTakmicar().getSkakaonica().getK()) {
			skok.setZbirPoena(60.0 - skok.getTakmicar().getSkakaonica().getD());
		}
	
		return skok;
	}

}
