package jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.service.SkokService;
import jwd.test.support.SkokDTOToSkok;
import jwd.test.support.SkokToSkokDTO;
import jwd.test.web.dto.SkokDTO;
import jwd.test.web.dto.TakmicarDTO;

@RestController
@RequestMapping(value="api/skokovi")
public class ApiSkok {
	
	@Autowired
	private SkokService skokService;
	@Autowired
	private SkokToSkokDTO toDto;
	@Autowired
	private SkokDTOToSkok toSkok;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SkokDTO>> get(){
		return new ResponseEntity<>(
				toDto.convert(skokService.findAll()),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<SkokDTO> add(
			@Validated @RequestBody SkokDTO noviSkok){
		
		Skok skok = toSkok.convert(noviSkok);
		skokService.save(skok); 

		return new ResponseEntity<>(toDto.convert(skok),
				HttpStatus.CREATED);

	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}/skok")
	public ResponseEntity<SkokDTO> skok(@PathVariable Long id){
		Skok skok = skokService.zbirPoena(id);
		if(skok != null) {
			return new ResponseEntity<>(toDto.convert(skok),
				HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(
					HttpStatus.BAD_REQUEST);
		}
	}

}
