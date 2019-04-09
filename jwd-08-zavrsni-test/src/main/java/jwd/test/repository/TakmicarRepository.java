package jwd.test.repository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jwd.test.model.Takmicar;

@Repository
public interface TakmicarRepository extends JpaRepository<Takmicar, Long> {
	
	
	@Query("SELECT t FROM Takmicar t WHERE "

			+ "(:skakaonicaId IS NULL or t.skakaonica.id = :skakaonicaId ) AND "

			+ "(:imePrezime IS NULL or t.imePrezime like :imePrezime ) AND "

			+ "(:drzava IS NULL OR t.drzava like :drzava)"

			)

	Page<Takmicar> pretraga(

			@Param("skakaonicaId") Long skakaonicaId, 

			@Param("imePrezime") String imePrezime, 

			@Param("drzava") String drzava,

			Pageable pageRequest);
}
