package jwd.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;

@Entity
public class Skakaonica {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column(nullable=false, unique=true)
	private String naziv;
	@Column
	private Double k;
	@Column
	private Double d;
	
	@OneToMany(mappedBy="skakaonica", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Takmicar> takmicari = new ArrayList<>();
	
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
	public List<Takmicar> getTakmicari() {
		return takmicari;
	}
	public void setTakmicari(List<Takmicar> takmicari) {
		this.takmicari = takmicari;
	}
	
	public void addTakmicar(Takmicar takmicar){

		this.takmicari.add(takmicar);
		if(!this.equals(takmicar.getSkakaonica())){
			takmicar.setSkakaonica(this);

		}

	}
	
	
	

}
