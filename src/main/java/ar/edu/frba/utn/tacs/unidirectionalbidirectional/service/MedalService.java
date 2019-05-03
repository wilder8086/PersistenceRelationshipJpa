package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import java.util.List;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.MedalRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Medal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedalService {
	
    @Autowired
    MedalRepository medalRepository;



    public Medal getMedalById(Long id) {
        return medalRepository.getById(id);
    }

    
    public Medal addMedal(Medal medal) {
        return medalRepository.save(medal);

    }


	public List<Medal> getMedals() {
		// TODO Auto-generated method stub
		return medalRepository.findAll();
	}    
}
