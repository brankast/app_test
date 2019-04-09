package jwd.test.web.dto;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

public class SkakaonicaDTO {
	
	private Long id;
	
	private String naziv;
	@DecimalMin("0.0")
	private Double k;
	@DecimalMin("1.2")
	@DecimalMax("4.2")
	private Double d;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Double getK() {
		return k;
	}

	public void setK(Double k) {
		this.k = k;
	}

	public Double getD() {
		return d;
	}

	public void setD(Double d) {
		this.d = d;
	}
	
	

}
