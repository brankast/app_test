package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.service.SkokService;
import jwd.test.service.TakmicarService;
import jwd.test.web.dto.SkokDTO;

@Component
public class SkokDTOToSkok implements Converter<SkokDTO, Skok> {

	@Autowired
	private SkokService skokService;
	@Autowired
	private TakmicarService takmicarService;
	
	@Override
	public Skok convert(SkokDTO source) {
		Skok skok;
		Takmicar t = takmicarService.findOne(source.getTakmicarId());
		
		if(source.getId() == null) {
			skok = new Skok();
		}else {
			skok = skokService.findOne(source.getId());
		}
		
		skok.setDaljina(source.getDaljina());
		skok.setOcenaSudija(source.getOcenaSudija());
		skok.setTakmicar(t);
		skok.setZbirPoena(source.getZbirPoena());
		
		return skok;
	}
	
	
	public List<Skok> convert (List<SkokDTO> dtos) {
		List<Skok> skokovi = new ArrayList<>();
		
		for (SkokDTO s : dtos) {
			skokovi.add(convert(s));
		}
		
		return skokovi;
	}

}
