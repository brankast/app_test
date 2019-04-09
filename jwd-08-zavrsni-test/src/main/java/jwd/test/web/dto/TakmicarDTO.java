package jwd.test.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

public class TakmicarDTO {
	
	private Long id;
	
	private String imePrezime;
	@Length( min=3, max=40)
	private String drzava;
	private Integer visina;
	@Email
	private String email;
	private Integer godinaRodjenja;
	
	private Long skakaonicaId;
	private String skakaonicaNaziv;
	
	
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
	public Long getSkakaonicaId() {
		return skakaonicaId;
	}
	public void setSkakaonicaId(Long skakaonicaId) {
		this.skakaonicaId = skakaonicaId;
	}
	public String getSkakaonicaNaziv() {
		return skakaonicaNaziv;
	}
	public void setSkakaonicaNaziv(String skakaonicaNaziv) {
		this.skakaonicaNaziv = skakaonicaNaziv;
	}
	
	

}
