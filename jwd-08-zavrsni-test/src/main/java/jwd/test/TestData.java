package jwd.test;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.test.model.Skakaonica;
import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.service.SkakaonicaService;
import jwd.test.service.SkokService;
import jwd.test.service.TakmicarService;



@Component
public class TestData {

	@Autowired
	private SkakaonicaService skService;
	@Autowired
	private TakmicarService tkService;
	@Autowired
	private SkokService skokService;
	
	@PostConstruct
	public void init() {
		
		Skakaonica ska1 = new Skakaonica();
		ska1.setD(2.0);
		ska1.setK(15.0);
		ska1.setNaziv("Satenbergasance");
		skService.save(ska1);
		
		Skakaonica ska2 = new Skakaonica();
		ska2.setD(3.0);
		ska2.setK(14.0);
		ska2.setNaziv("Bergizelsance");
		skService.save(ska2);
		
		Takmicar t1 = new Takmicar();
		t1.setDrzava("Finska");
		t1.setEmail("t1@email.com");
		t1.setGodinaRodjenja(1987);
		t1.setImePrezime("Hari Oli");
		t1.setVisina(192);
		t1.setSkakaonica(ska1);
		tkService.save(t1);
		
		Takmicar t2 = new Takmicar();
		t2.setDrzava("Nemacka");
		t2.setEmail("t2@email.com");
		t2.setGodinaRodjenja(1989);
		t2.setImePrezime("Martin Smit");
		t2.setVisina(193);
		t2.setSkakaonica(ska2);
		tkService.save(t2);
		
		Takmicar t3 = new Takmicar();
		t3.setDrzava("Austrija");
		t3.setEmail("t3@email.com");
		t3.setGodinaRodjenja(1987);
		t3.setImePrezime("Sep Bradl");
		t3.setVisina(187);
		t3.setSkakaonica(ska1);
		tkService.save(t3);
		
		Takmicar t4 = new Takmicar();
		t4.setDrzava("Slovacka");
		t4.setEmail("t4@email.com");
		t4.setGodinaRodjenja(1993);
		t4.setImePrezime("Jakub Banda");
		t4.setVisina(177);
		t4.setSkakaonica(ska1);
		tkService.save(t4);
		
		Takmicar t5 = new Takmicar();
		t5.setDrzava("Finska");
		t5.setEmail("t5@email.com");
		t5.setGodinaRodjenja(1992);
		t5.setImePrezime("Jane Ahonen");
		t5.setVisina(183);
		t5.setSkakaonica(ska2);
		tkService.save(t5);
		
		
		
	}
}