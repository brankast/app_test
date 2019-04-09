package jwd.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Skok {
	
	@Id
	@GeneratedValue
	@Column
	private Long id;
	@Column
	private Double daljina;
	@Column
	private Double ocenaSudija;
	@Column
	private Double zbirPoena;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Takmicar takmicar;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getDaljina() {
		return daljina;
	}
	public void setDaljina(Double daljina) {
		this.daljina = daljina;
	}
	public Double getOcenaSudija() {
		return ocenaSudija;
	}
	public void setOcenaSudija(Double ocenaSudija) {
		this.ocenaSudija = ocenaSudija;
	}
	public Double getZbirPoena() {
		return zbirPoena;
	}
	public void setZbirPoena(Double zbirPoena) {
		this.zbirPoena = zbirPoena;
	}
	public Takmicar getTakmicar() {
		return takmicar;
	}
	public void setTakmicar(Takmicar takmicar) {
		this.takmicar = takmicar;
		
		if(takmicar != null && !takmicar.getSkokovi().contains(this)) {
			takmicar.getSkokovi().add(this);
		}
	}
}
