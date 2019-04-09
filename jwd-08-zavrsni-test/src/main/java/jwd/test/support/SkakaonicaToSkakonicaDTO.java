package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Skakaonica;
import jwd.test.web.dto.SkakaonicaDTO;

@Component
public class SkakaonicaToSkakonicaDTO implements Converter<Skakaonica, SkakaonicaDTO>{

	@Override
	public SkakaonicaDTO convert(Skakaonica source) {
		SkakaonicaDTO dto = new SkakaonicaDTO();
		
		dto.setD(source.getD());
		dto.setId(source.getId());
		dto.setK(source.getK());
		dto.setNaziv(source.getNaziv());
		return dto;
	}
	
	public List<SkakaonicaDTO> convert(List<Skakaonica> sk) {
		 List<SkakaonicaDTO> dtos = new ArrayList<>();
		 
		 for (Skakaonica s : sk) {
			 dtos.add(convert(s));
		 }
		 
		 return dtos;
	}
	

}
