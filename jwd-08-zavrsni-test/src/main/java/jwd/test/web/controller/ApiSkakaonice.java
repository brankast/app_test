package jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.test.service.SkakaonicaService;
import jwd.test.support.SkakaonicaDTOToSkakaonica;
import jwd.test.support.SkakaonicaToSkakonicaDTO;
import jwd.test.web.dto.SkakaonicaDTO;

@RestController
@RequestMapping (value = "/api/skakaonice")
public class ApiSkakaonice {

	
	@Autowired
	private SkakaonicaService skService;
	@Autowired
	private SkakaonicaDTOToSkakaonica toSk;
	@Autowired
	private SkakaonicaToSkakonicaDTO toDto;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<SkakaonicaDTO>> get(){
		return new ResponseEntity<>(
				toDto.convert(skService.findAll()),
				HttpStatus.OK);
	}
}
