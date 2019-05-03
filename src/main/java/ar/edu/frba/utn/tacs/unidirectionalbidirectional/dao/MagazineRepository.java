package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Magazine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Integer> {

}
