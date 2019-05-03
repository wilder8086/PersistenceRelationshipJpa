package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Soldier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldierRepository extends JpaRepository<Soldier, Long> {


}
