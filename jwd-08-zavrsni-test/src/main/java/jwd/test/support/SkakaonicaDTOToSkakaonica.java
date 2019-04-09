package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Skakaonica;
import jwd.test.web.dto.SkakaonicaDTO;

@Component
public class SkakaonicaDTOToSkakaonica implements Converter<SkakaonicaDTO, Skakaonica> {

	@Override
	public Skakaonica convert(SkakaonicaDTO source) {
		Skakaonica s = new Skakaonica();
		
		s.setD(source.getD());
		s.setId(source.getId());
		s.setK(source.getK());
		s.setNaziv(source.getNaziv());
		return s;
	}
	
	public List<Skakaonica> convert(List<SkakaonicaDTO> dtos) {
		List<Skakaonica> sk = new ArrayList<>();
		
		for (SkakaonicaDTO s : dtos) {
			sk.add(convert(s));
		}
		
		return sk;
	}
	
	

}
