package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Author;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sun.security.krb5.internal.PAData;

@Repository
public interface ParentDao extends JpaRepository<Parent, Integer> {

}
