package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.MagazineRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Magazine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MagazineService {
	
    @Autowired
    MagazineRepository magazineRepository;

    public List<Magazine> getAuthors() {
        return magazineRepository.findAll();
    }


    public Magazine createMagazine(Magazine magazine) {
        return magazineRepository.save(magazine);

    }

}
