package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Child;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDao extends JpaRepository<Child, Integer> {

}
