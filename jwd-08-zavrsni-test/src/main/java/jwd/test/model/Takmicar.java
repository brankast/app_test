package jwd.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Takmicar {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column (nullable=false)
	private String imePrezime;
	@Column
	private String drzava;
	@Column
	private Integer visina;
	@Column(unique=true)
	private String email;
	@Column
	private Integer godinaRodjenja;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Skakaonica skakaonica;
	
	@OneToMany(mappedBy="takmicar", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Skok> skokovi = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImePrezime() {
		return imePrezime;
	}
	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public Integer getVisina() {
		return visina;
	}
	public void setVisina(Integer visina) {
		this.visina = visina;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGodinaRodjenja() {
		return godinaRodjenja;
	}
	public void setGodinaRodjenja(Integer godinaRodjenja) {
		this.godinaRodjenja = godinaRodjenja;
	}
	public Skakaonica getSkakaonica() {
		return skakaonica;
	}
	public void setSkakaonica(Skakaonica skakaonica) {
		this.skakaonica = skakaonica;
		
		if(skakaonica != null && !skakaonica.getTakmicari().contains(this)) {
			skakaonica.getTakmicari().add(this);
		}
	}
	public List<Skok> getSkokovi() {
		return skokovi;
	}
	public void setSkokovi(List<Skok> skokovi) {
		this.skokovi = skokovi;
	}
	
	public void addSkok(Skok skok){
		this.skokovi.add(skok);
		if(!this.equals(skok.getTakmicar())){
			skok.setTakmicar(this);

		}

	}

}
