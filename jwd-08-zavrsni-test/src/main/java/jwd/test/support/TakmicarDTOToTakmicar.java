package jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.test.model.Skakaonica;
import jwd.test.model.Takmicar;
import jwd.test.service.SkakaonicaService;
import jwd.test.service.TakmicarService;
import jwd.test.web.dto.TakmicarDTO;

@Component
public class TakmicarDTOToTakmicar  implements Converter<TakmicarDTO, Takmicar>{
	
	@Autowired
	private TakmicarService takmicarService;
	@Autowired
	private SkakaonicaService skakaonicaService;
	
	
	@Override
	public Takmicar convert(TakmicarDTO source) {
		Takmicar takmicar;
		
		Skakaonica s = skakaonicaService.findOne(source.getSkakaonicaId());
		
		if(source.getId() == null) {
			takmicar = new Takmicar();
		}else {
			takmicar = takmicarService.findOne(source.getId());
		}
		
		takmicar.setDrzava(source.getDrzava());
		takmicar.setEmail(source.getEmail());
		takmicar.setGodinaRodjenja(source.getGodinaRodjenja());
		takmicar.setImePrezime(source.getImePrezime());
		takmicar.setSkakaonica(s);
		takmicar.setVisina(source.getVisina());
		return takmicar;
	}
	
	public List<Takmicar> convert(List<TakmicarDTO> dto) {
		List<Takmicar> t = new ArrayList<>();
		
		for (TakmicarDTO d : dto) {
			t.add(convert(d));
		}
		
		return t;
	}
	
	

}
