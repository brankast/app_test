package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Takmicar;
import jwd.test.web.dto.TakmicarDTO;

@Component
public class TakmicarToTakmicarDTO implements Converter<Takmicar, TakmicarDTO>{

	@Override
	public TakmicarDTO convert(Takmicar source) {
		TakmicarDTO dto = new TakmicarDTO();
		
		dto.setDrzava(source.getDrzava());
		dto.setEmail(source.getEmail());
		dto.setGodinaRodjenja(source.getGodinaRodjenja());
		dto.setId(source.getId());
		dto.setImePrezime(source.getImePrezime());
		dto.setSkakaonicaId(source.getSkakaonica().getId());
		dto.setSkakaonicaNaziv(source.getSkakaonica().getNaziv());
		dto.setVisina(source.getVisina());
		
		return dto;
	}
	
	public List<TakmicarDTO> convert (List<Takmicar> t) {
		
		List<TakmicarDTO> dtos = new ArrayList<>();
		
		for (Takmicar ta : t) {
			dtos.add(convert(ta));
		}
		
		return dtos;
	}

}
