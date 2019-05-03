package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.MagazineRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.SoldierRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Magazine;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Soldier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoldierService {
	
    @Autowired
    SoldierRepository soldierRepository;

    public List<Soldier> getSoldiers() {
        return soldierRepository.findAll();
    }


    public Soldier createSoldier(Soldier magazine) {
        return soldierRepository.save(magazine);

    }

}
