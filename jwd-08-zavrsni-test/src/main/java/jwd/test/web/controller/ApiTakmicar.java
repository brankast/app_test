package jwd.test.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import jwd.test.model.Skok;
import jwd.test.model.Takmicar;
import jwd.test.service.SkokService;
import jwd.test.service.TakmicarService;
import jwd.test.support.SkokDTOToSkok;
import jwd.test.support.SkokToSkokDTO;
import jwd.test.support.TakmicarDTOToTakmicar;
import jwd.test.support.TakmicarToTakmicarDTO;
import jwd.test.web.dto.SkokDTO;
import jwd.test.web.dto.TakmicarDTO;

@RestController
@RequestMapping(value = "api/takmicari")
public class ApiTakmicar {
	@Autowired
	private TakmicarService takmicarService;
	@Autowired
	private SkokService skokService;
	@Autowired
	private TakmicarDTOToTakmicar toTak;
	@Autowired
	private TakmicarToTakmicarDTO toDtoT;
	@Autowired
	private SkokToSkokDTO toDtoS;
	@Autowired
	private SkokDTOToSkok toSkok;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<TakmicarDTO>> get(

			@RequestParam(required=false) Long skakaonicaId,
			@RequestParam(required=false) String imePrezime,
			@RequestParam(required=false) String drzava,
			@RequestParam(defaultValue="0") int pageNum){

		Page<Takmicar> takmicar;

		if(skakaonicaId != null || imePrezime != null || drzava != null) {

			takmicar = takmicarService.search(skakaonicaId, imePrezime, drzava, pageNum);

		}else{
			takmicar = takmicarService.findAll(pageNum);
		}
		HttpHeaders headers = new HttpHeaders();

		headers.add("totalPages", Integer.toString(takmicar.getTotalPages()) );

		return  new ResponseEntity<>(
				toDtoT.convert(takmicar.getContent()),
				headers,
				HttpStatus.OK);
	}

	

	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<TakmicarDTO> get(
			@PathVariable Long id){

		Takmicar tak = takmicarService.findOne(id);
		
		if(tak==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(
				toDtoT.convert(tak),
				HttpStatus.OK);

	}

	

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<TakmicarDTO> add(
			@Validated @RequestBody TakmicarDTO noviTakmicar){
		
		Takmicar takmicar = toTak.convert(noviTakmicar);
		takmicarService.save(takmicar); 

		return new ResponseEntity<>(toDtoT.convert(takmicar),
				HttpStatus.CREATED);

	}

	

	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<TakmicarDTO> edit(
			@PathVariable Long id,
			@Validated @RequestBody TakmicarDTO izmenjen){

		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Takmicar tak = toTak.convert(izmenjen);
		takmicarService.save(tak);

		return new ResponseEntity<>(toDtoT.convert(tak),
				HttpStatus.OK);
	}

	

	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<TakmicarDTO> delete(@PathVariable Long id){

	
		Takmicar deleted = takmicarService.remove(id);

		if(deleted == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(
				toDtoT.convert(deleted),
				HttpStatus.OK);

	}

	@RequestMapping(value="/{id}/skokovi")
	public ResponseEntity<List<SkokDTO>> getSkok (
			@PathVariable Long id) {
		
		List<Skok> skokovi = skokService.findByTakmicarId(id);
		
		return new ResponseEntity<>(toDtoS.convert(skokovi), HttpStatus.OK);
	}

	
	
	@ExceptionHandler
	public ResponseEntity<Void> validationHandler(
					DataIntegrityViolationException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}

}