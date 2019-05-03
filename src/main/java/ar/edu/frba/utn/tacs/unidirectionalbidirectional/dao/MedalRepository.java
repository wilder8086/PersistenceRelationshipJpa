package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Medal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {

	Medal getById(Long id);
	
}
