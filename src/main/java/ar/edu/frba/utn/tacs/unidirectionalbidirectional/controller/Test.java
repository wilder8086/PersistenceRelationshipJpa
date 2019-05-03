package ar.edu.frba.utn.tacs.unidirectionalbidirectional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.MagazineRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Magazine;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Publisher;

public class Test {

	@Autowired
	private static MagazineRepository bookRepository;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//bookRepository.save(new Magazine("Book 1", new Publisher("Publisher A"), new Publisher("Publisher B")));
	}

}
