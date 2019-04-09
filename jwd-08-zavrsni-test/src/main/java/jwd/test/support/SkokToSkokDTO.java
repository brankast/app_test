package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Skok;
import jwd.test.web.dto.SkokDTO;

@Component
public class SkokToSkokDTO implements Converter<Skok, SkokDTO>{

	@Override
	public SkokDTO convert(Skok source) {
		SkokDTO dto = new SkokDTO();
		
		dto.setDaljina(source.getDaljina());
		dto.setId(source.getId());
		dto.setOcenaSudija(source.getOcenaSudija());
		dto.setZbirPoena(source.getZbirPoena());
		
		dto.setTakmicarId(source.getTakmicar().getId());
		dto.setTakmicarNaziv(source.getTakmicar().getImePrezime());
		return dto;
	}
	
	public List<SkokDTO> convert (List<Skok> skokovi) {
		 List<SkokDTO> dtos = new ArrayList<>();
		 
		 for (Skok s : skokovi) {
			 dtos.add(convert(s));
		 }
		 
		 return dtos;
	}
	
	

}
