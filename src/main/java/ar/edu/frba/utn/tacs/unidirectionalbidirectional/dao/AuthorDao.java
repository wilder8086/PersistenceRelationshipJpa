package ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDao extends JpaRepository<Author, Long> {

}
