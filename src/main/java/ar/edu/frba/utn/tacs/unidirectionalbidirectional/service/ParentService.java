package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.ParentDao;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Author;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Parent;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    @Autowired
    ParentDao parentDao;

    public Parent createParent(Parent parent) {
        return parentDao.save(parent);
    }

}
